function obj2string(data) {
    var arr = [];
    // data.t = new Date().getTime();
    for (var key in data) {
        arr.push(encodeURIComponent(key) + "=" + encodeURIComponent(data[key]));
    }
    return arr.join("&") + "&" + new Date().getTime();
}
function ajax(option) {
    //创建一个异步对象
    var xmlHttp, timer, str;
    str = obj2string(option.data);
    if (window.XMLHttpRequest) {
        xmlHttp = new XMLHttpRequest();
    }
    else {
        //code for IE6 IE5
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    //设置请求方式与地址
    // method: GET 或 POST
    // url: 文件在服务器的地址
    // async: true(异步) false(同步) Ajax就是用来异步处理的
    // console.log(obj2string(obj));
    if (option.method.toUpperCase() === "GET") {
        xmlHttp.open(option.method,option.url + "?" + str,true);
        //发送请求
        xmlHttp.send();
    } else {
        xmlHttp.open(option.method,option.url,true);
        //发送请求
        xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xmlHttp.send(str);
    }
    //监听状态变化
    xmlHttp.onreadystatechange = function(){
        /*
        0:请求未初始化
        1:服务器连接已建立
        2:请求已接收
        3:请求处理中
        4:请求已完成,响应已就绪
        */
        if (xmlHttp.readyState === 4) {
            clearInterval(timer)
            //判断网页状态码
            if(xmlHttp.status >= 200 && xmlHttp.status < 300 || xmlHttp.status ===304){
                //处理返回结果
                // console.log("接收到服务器的数据",xmlHttp.responseText);
                option.success(xmlHttp);
            }else{
                // console.log("接收失败");
                option.error(xmlHttp);
            }
        }
    }
    if (option.timeout) {
        timer = setInterval(function(){
            console.log("中断请求");
            xmlHttp.abort();
            clearInterval(timer);
        },option.timeout)
    }
}
