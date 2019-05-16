(function ($) {
    function crateCommentInfo(obj) {
        if (typeof (obj.time) == "undefined" || obj.time == "") {
            obj.time = getNowDateFormat();
        }
        var el = "<div class='comment-info'><header><img src='" + obj.img + "'></header><div class='comment-right'><h3>" + obj.replyName + "</h3>"
            + "<div class='comment-content-header'><span><i class='glyphicon glyphicon-time'></i>" + obj.time + "</span>";
        if (typeof (obj.address) != "undefined" && obj.browse != "") {
            el = el + "<span><i class='glyphicon glyphicon-map-marker'></i>" + obj.address + "</span>";
        }
        el = el + "</div><p class='content'>" + obj.content + "</p><div class='comment-content-footer'><div class='row'><div class='col-md-10'>";
        if (typeof (obj.osname) != "undefined" && obj.osname != "") {
            el = el + "<span><i class='glyphicon glyphicon-pushpin'></i> 来自:" + obj.osname + "</span>";
        }
        if (typeof (obj.browse) != "undefined" && obj.browse != "") {
            el = el + "<span><i class='glyphicon glyphicon-globe'></i> " + obj.browse + "</span>";
        }
        el = el + "</div><div class='col-md-2'><span class='reply-btn'>回复</span></div></div></div><div class='reply-list'>";
        if (obj.replyBody != "" && obj.replyBody.length > 0) {
            var arr = obj.replyBody;
            for (var j = 0; j < arr.length; j++) {
                var replyObj = arr[j];
                el = el + createReplyComment(replyObj);
            }
        }
        el = el + "</div></div></div>";
        return el;
    }

    $.fn.addCommentList = function (options) {
        var defaults = {data: [], add: ""}
        var option = $.extend(defaults, options);
        if (option.data.length > 0) {
            var dataList = option.data;
            var totalString = "";
            for (var i = 0; i < dataList.length; i++) {
                var obj = dataList[i];
                var objString = crateCommentInfo(obj);
                totalString = totalString + objString;
            }
            $(this).append(totalString).find(".reply-btn").click(function () {
                if ($(this).parent().parent().find(".replybox").length > 0) {
                    $(".replybox").remove();
                } else {
                    $(".replybox").remove();
                    replyClick($(this));
                }
            });
            $(".reply-list-btn").click(function () {
                if ($(this).parent().parent().find(".replybox").length > 0) {
                    $(".replybox").remove();
                } else {
                    $(".replybox").remove();
                    replyClick($(this));
                }
            })
        }
        if (option.add != "") {
            obj = option.add;
            var str = crateCommentInfo(obj);
            $(this).prepend(str).find(".reply-btn").click(function () {
                replyClick($(this));
            });
        }
    }
})(jQuery);