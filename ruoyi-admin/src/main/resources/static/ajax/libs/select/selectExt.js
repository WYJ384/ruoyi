function initSelect(inputId, setting, zNodes) {
	var html = '<span class="select2 select2-container '+inputId+' select2-container--default select2-container--below select2-container--focus" dir="ltr" style="width: 100%;">';
	html += '<span class="selection">';
	html += '<span class="select2-selection select2-selection--multiple" role="combobox" aria-haspopup="true" aria-expanded="false" tabindex="-1">';
	html += '<ul class="select2-selection__rendered">';
	html += '<li class="select2-search select2-search--inline">';
	html += '<input id="' + inputId + 'keyword" class="select2-search__field valid" type="search" tabindex="0" autocomplete="off" autocorrect="off" autocapitalize="off" spellcheck="false" role="textbox" aria-autocomplete="list" placeholder="" style="width: 100%;">';
	html += '</li>';
	html += '</ul>';
	html += '</span>';
	html += '</span>';
	html += '</span>';
	html += '<span class="dropdown-wrapper" aria-hidden="true" style="display: none;">';
	html += '<ul id="' + inputId + 'Tree" class="ztree"></ul>';
	html += '</span>';
	$("#"+inputId).after(html);
	$.fn.zTree.init($("#" + inputId + 'Tree'), setting, zNodes);
	fuzzySearch(inputId + 'Tree',inputId+"keyword",null,true); //初始化模糊搜索方法
	$(".select2-selection__rendered").on("click", ".select2-selection__choice__remove", function() {
		var attrId = $(this).parent().attr("attr-id");
		var userIds = $("#" + inputId).val();
		arrUserIds = userIds.split(",");
		arrUserIds.pop(attrId);
		$("#" + inputId).val(arrUserIds.join(","))
		$(this).parent().remove();
		event.stopPropagation(); //  阻止事件冒泡
	});
	$(".select2-search__field").focus();
	$("body").on("click", ".select2-container."+inputId, function() {
		
		$container = $(this).next();
		var ariaHidden = $container.attr("aria-hidden");
		if(ariaHidden == 'true') {
			$container.show();
			$container.attr("aria-hidden", false);
		} else {
			$container.hide();
			$container.attr("aria-hidden", true);
		}
		event.stopPropagation(); //  阻止事件冒泡
	});

}

function onClick(event, treeId, treeNode, clickFlag) {
	//获取原本的input标签
	$input = $("#" + treeId).parent().prev().prev("input");
	var inputId = $input.attr("id");
	if(!treeNode.isParent) {
		console.log(treeNode.id)
		console.log(treeNode.name)
		var html = '<li class="select2-selection__choice" title="" attr-id="' + treeNode.id + '"><span class="select2-selection__choice__remove" role="presentation">×</span>' + treeNode.name + '</li>'
		$("#" + treeId).parent().prev().find(".select2-search--inline").before(html)
		if($("#" + inputId).val() != "") {
			$("#" + inputId).val($("#" + inputId).val() + "," + treeNode.id)
		} else {
			$("#" + inputId).val(treeNode.id)
		}
		
	}
	event.stopPropagation(); //  阻止事件冒泡
}

