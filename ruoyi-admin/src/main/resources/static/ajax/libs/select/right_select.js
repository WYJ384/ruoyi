var currFocus;

function setCurrFocus(obj) {
    currFocus = obj;
}

$("#btnSubmit").click(function () {

    var id = $(currFocus).attr("id");
    alert(id)
})

//ztree配置
var setting = {
    check: {
        enable: true //checkbox
    },
    view: {
        nameIsHTML: true, //允许name支持html
        selectedMulti: false
    },
    edit: {
        enable: false,
        editNameSelectAll: false
    },
    data: {
        simpleData: {
            enable: true
        }
    },
    callback: {
        onClick: onClick
    }
};

$(document).ready(function () {
    //从服务器读取数据并初始化树形图
    loadDataFromServer(ctx + "system/user/selectUserTree");
    initSelect();
    $(".select2-selection__rendered").on("click", ".select2-selection__choice__remove", function () {
        $this = $(this);
        $or_input = $this.parents('.select2-container').next(); //原本用户的文本框
        var attrId = $(this).parent().attr("attr-id");
        var Ids = $or_input.val();
        arrIds = Ids.split(",");
        arrIds.pop(attrId);
        $or_input.val(arrIds.join(","));
        $this.parent().remove();

    });
});

/**
 * 通过ajax方法从服务器获取数据并初始化树形图
 */
function loadDataFromServer(urlStr) {
    $.ajax({
        type: "post",
        dataType: "json",
        url: urlStr, //服务请求地址
        success: function (data) {
            initThisZtree(data); //传入数据,初始化ztree

        }
    });
}

/**
 * 初始化ztree
 *
 * @param {Object} data
 */
function initThisZtree(data) {
    //初始化ztree三个参数分别是(jQuery对象,ztree设置,树节点数据)
    var treeObj = $.fn.zTree.init($("#userTree"), setting, data);
	$._tree = treeObj;
    fuzzySearch('userTree', 'ukeyword', null, true); //初始化模糊搜索方法
    treeObj.expandAll(false);
}

function onClick(event, treeId, treeNode, clickFlag) {
    if (currFocus == null) {
        return;
    }
    //获取原本的input标签
    $input = $(currFocus);
    if (!treeNode.isParent) {
        var name = treeNode.name;
        var id = treeNode.id;
        var html = '<li class="select2-selection__choice" title="' + name + '" attr-id="' + id + '"><span class="select2-selection__choice__remove" role="presentation">×</span>' + name + '</li>'
        $input.parent().before(html);
        setCurrFocus(currFocus);
        $input.focus();
        $or_input = $input.parents('.select2-container').next(); //原本用户的文本框
        if ($or_input.val() != "") {
            $or_input.val($or_input.val() + "," + id)
        } else {
            $or_input.val(id)
        }

    }
    event.stopPropagation(); //  阻止事件冒泡
}

function initSelect() {
    $(".select2-hidden-accessible").hide()
    html = '<span class="select2 select2-container select2-container--default select2-container--below select2-container--focus" dir="ltr" style="width: 100%;">'
    html += '<span class="selection">';
    html += '<span class="select2-selection select2-selection--multiple" role="combobox" aria-haspopup="true" aria-expanded="false" tabindex="-1">';
    html += '<ul class="select2-selection__rendered">';
    html += '<li class="select2-search select2-search--inline">';
    html += '<input class="select2-search__field valid " type="search" onclick="setCurrFocus(this)" style="width: 100%;">';
    html += '</li>';
    html += '</ul>';
    html += '</span>';
    html += '</span>';
    html += '</span>';
    $(".select2-hidden-accessible").before(html);
}

$('#btnExpand').click(function () {
	$._tree.expandAll(true);
    $(this).hide();
    $('#btnCollapse').show();
});

$('#btnCollapse').click(function () {
	$._tree.expandAll(false);
    $(this).hide();
    $('#btnExpand').show();
});

$('#btnRefresh').click(function () {
	loadDataFromServer(ctx + "system/user/selectUserTree");
});