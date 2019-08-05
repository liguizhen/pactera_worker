<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no, width=device-width"/>
    <meta name=”apple-mobile-web-app-capable” content=”yes” />
    <meta name=”apple-mobile-web-app-status-bar-style” content=black” />
    <meta content="telephone=no" name="format-detection" />
</head>
<style>
.top{
padding:15px;
border:1px;
}
.table{
padding:15px;
}
.ant-btn {
    line-height: 1.499;
    position: relative;
    display: inline-block;
    font-weight: 400;
    white-space: nowrap;
    text-align: center;
    background-image: none;
    border: 1px solid transparent;
    -webkit-box-shadow: 0 2px 0 rgba(0,0,0,0.015);
    box-shadow: 0 2px 0 rgba(0,0,0,0.015);
    cursor: pointer;
    -webkit-transition: all .3s cubic-bezier(.645, .045, .355, 1);
    transition: all .3s cubic-bezier(.645, .045, .355, 1);
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
    user-select: none;
    -ms-touch-action: manipulation;
    touch-action: manipulation;
    height: 32px;
    padding: 0 15px;
    font-size: 14px;
    border-radius: 4px;
    color: rgba(0,0,0,0.65);
    background-color: #fff;
    border-color: #d9d9d9;
}
</style>
<body>
    <div class="top">
        <button type="button" id="import" class="ant-btn">导入</button>
        <button type="button" id="search" class="ant-btn">查询</button>
    </div>
    <div class="table">
        <table border="1">
          <tr>
            <th width="80px">姓名</th>
            <th width="100px">总打卡次数</th>
            <th>没有打卡日期</th>
          </tr>
          <c:forEach var="item" items="${employeeList}">
             <tr>
                <td>${item.employee}</td>
                <td>${item.total}</td>
                <td>${item.lackDate}</td>
             </tr>
          </c:forEach>
        </table>
    </div>
</body>
<script src="/static/js/jquery.min.js"></script>
<script type="text/javascript">
 $(function () {
    $("#search").unbind("click").bind('click', function () {
        window.location.href = "/api/pactera/index";
        return false;
    });

    $("#import").unbind("click").bind('click', function () {
        window.location.href = "/api/pactera/import";
        return false;
    });
})
</script>
</html>
