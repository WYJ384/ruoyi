
/*--周日历--*/
function jcalendar_week(options){
	var _this=this;
	var defaults={
		element: "#jcalendar_week",
		dayclick:function(date,obj){
			//day点击事件
			$(obj).addClass("calendar_day_act").siblings().removeClass("calendar_day_act");
		},
		dayaddclass:function(date){
			return null;
		},
		showbtn:true,
	};
	var opts = $.extend(defaults,options);

	var calendarid = $(opts.element);
	//DOM添加
	function addDOM(){
		calendarid.html("");
		var before_btn=opts.showbtn?'<button class="switch_month beforem_btn">&lt;</button>':'';
		var after_btn=opts.showbtn?'<button class="switch_month afterm_btn">&gt;</button>':'';
		var header_dom = '<div class="flex_i calendar_header ">'+
			before_btn+
			'<div class="flex_auto calendar_info" onclick="$(\'#pop\').show();"></div>'+
			after_btn+
			'</div>';
		var week_dom='<li>周日</li><li>周一</li><li>周二</li><li>周三</li><li>周四</li><li>周五</li><li>周六</li>';
		var week_bar_dom = '<ul class="calendar_tr calendar_week">'+week_dom+'</ul>';
		var day_bar_dom = '<ul class="calendar_tr calendar_day_bar"></ul>';
		calendarid.append(header_dom+day_bar_dom+week_bar_dom);
	}
	addDOM();

	//获取今天
	var todaydate = function(){
		var nstr = new Date();
		var ynow = nstr.getFullYear();
		var mnow = nstr.getMonth();
		var dnow = nstr.getDate();
		return [ynow,mnow,dnow];
	}
	//判断是否为闰年
	var is_leap = function(year){
		return (year%100==0?res=(year%400==0?1:0):res=(year%4==0?1:0));
	}
	//获取周第一天日期方法
	_this.weekfirstdate = function(year,weeknum){
		//获取当年月份天数数组
		var m_days=[31,28+is_leap(year),31,30,31,30,31,31,30,31,30,31];
		//获取当年第一天是周几
		var newyear_week=(new Date(year,0,1)).getDay();
		//新年到周第一天的总天数
		var week_day;
		if(newyear_week < 5){
			//新年第一天算年内第一周[周四在本年]
			week_day = 7*(weeknum-2)+(7-newyear_week+1);
		}else{
			//新年第一天是上年最后一周
			week_day = 7*(weeknum-1)+(7-newyear_week+1);
		}
		var startmouch;
		for(var i=0;i<m_days.length;i++){
			startmouch=i;
			if(week_day>m_days[i]){
				week_day-=m_days[i];
				if(i==m_days.length-1){
					year++;
					startmouch=0;
				}
			}else{
				break;
			}
		}
		return [year,startmouch,week_day];
	}

	//设置周日历
	var setdaydata = function(year,weeknum){

		//获取月份天数数组
		var m_days=[31,28+is_leap(year),31,30,31,30,31,31,30,31,30,31];
		//获取周第一天日期
		var datastart=_this.weekfirstdate(year,weeknum);
		//根据日期判断显示正确的数据（比如传入的值比总周数大）
		var trueweeknum = _this.getweeknum(datastart[0],datastart[1],datastart[2]);
		calendarid.attr({
			"year":trueweeknum[0],
			"weeknum":trueweeknum[1]
		})
		$("#setyear").val(trueweeknum[0]);
		$("#setweek").val(trueweeknum[1]);
		calendarid.find(".calendar_info").html(trueweeknum[1]+'周/'+trueweeknum[0]);

		var week_day="";
		var isdayaddclass=false;
		if(opts.dayaddclass()!==null){
			isdayaddclass=true;
		}
		var dayaddclass="";
		var newdate;
		for(var i=0;i<7;i++){
			newdate=new Date(datastart[0],datastart[1],datastart[2]+i);
			if(isdayaddclass){
				dayaddclass=" "+opts.dayaddclass(newdate.getFullYear()+'-'+(newdate.getMonth()+1)+'-'+newdate.getDate());
			}
			var istoday='';
			var todayarr=todaydate();
			if(newdate.getFullYear()==todayarr[0] && newdate.getMonth()==todayarr[1] && newdate.getDate()==todayarr[2]){
				istoday = '<span class="today_i">今天</span>';
			}
			var mstr=(newdate.getMonth()+1);
			if((newdate.getMonth()+1)<10){
				mstr="0"+mstr;
			}
			var dstr=newdate.getDate();
			if(newdate.getDate()<10){
				dstr="0"+dstr;
			}

			week_day+='<li aa=bb class="calendar_day'+dayaddclass+'" '+
				'date="'+newdate.getFullYear()+'-'+mstr+'-'+dstr+'">'+
				'<span class="calendar_day_i">'+newdate.getDate()+'</span>'+istoday+
				'</li>';
		}
		newdate=null;
		calendarid.find(".calendar_day_bar").html(week_day);
	}

	//传入日期为当年第几周
	_this.getweeknum = function(year,month,day){
		//获取月份天数数组
		var m_days=[31,28+is_leap(year),31,30,31,30,31,31,30,31,30,31];

		var newtonowday=0;
		for(var i=0;i<month;i++){
			newtonowday += m_days[i];
		}
		newtonowday += day;
		//获取当年第一天是周几
		var newyear_week=(new Date(year,0,1)).getDay();
		var fdaynothisy=false;
		//新年到周第一天的总天数
		if(newyear_week < 5){
			//新年第一天算年内第一周[周四在本年]
			newtonowday += newyear_week;
			if(newyear_week==0 && m_days[2]==29){
				fdaynothisy=true;
			}
		}else{
			//新年第一天是上年最后一周
			fdaynothisy=true;
			newtonowday -= (7-newyear_week);
		}
		var weeknum_result = Math.ceil(newtonowday/7);
		var weekyear=year;
		if(weeknum_result==0){
			var beforeyear_fweek=(new Date(weekyear-1,0,1)).getDay();
			if(beforeyear_fweek<5 && beforeyear_fweek>1 && fdaynothisy){
				weeknum_result=53;
			}else{
				weeknum_result=52;
			}
			weekyear--;
		}else if(weeknum_result>52){
			var year_lweek=(new Date(year,11,31)).getDay();
			if(year_lweek > 3 && newyear_week < 5){
				weeknum_result=53;
			}else{
				weekyear++;
				weeknum_result=1;
			}
		}
		return [weekyear,weeknum_result];
	}

	//DOM添加
	_this.confirmweek = function(year,weeknum){
		if(!year) year=$("#setyear").val();
		if(!weeknum) weeknum=$("#setweek").val();
		if(weeknum<1) weeknum=1;

		setdaydata(year,weeknum);

		//上一周
		calendarid.find(".beforem_btn").off("click").on("click",function(){
			var beforew=weeknum-1;
			var beforeweekfirst=_this.weekfirstdate(year,beforew);
			var beforeweekdata=_this.getweeknum(beforeweekfirst[0],beforeweekfirst[1],beforeweekfirst[2]);
			_this.confirmweek(beforeweekdata[0],beforeweekdata[1]);
		})
		//下一周
		calendarid.find(".afterm_btn").off("click").on("click",function(){
			var afterw=weeknum+1;
			var afterweekfirst=_this.weekfirstdate(year,afterw);
			var afterweekdata=_this.getweeknum(afterweekfirst[0],afterweekfirst[1],afterweekfirst[2]);
			_this.confirmweek(afterweekdata[0],afterweekdata[1]);
		})
		//day点击事件
		calendarid.find(".calendar_day").on("click",function(){
			var obj=$(this);
			opts.dayclick(obj.attr("date"),this);
		})
	}
	//本周
	_this.nowweek = function(){
		var todayarr=todaydate();
		var weekdata=_this.getweeknum(todayarr[0],todayarr[1],todayarr[2]);
		_this.confirmweek(weekdata[0],weekdata[1]);
	}
	_this.nowweek();
}