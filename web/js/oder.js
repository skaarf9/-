$(function(){
    ajax({
        "method": "get",
        "url": "GetOrderByPage",
        "timeout": 3000,
        "data": {"Page": 1
        },
        "success": function(xhr){
            let data = xhr.responseText;
            let json = JSON.parse(data);
            //onsole.log(json);
            let tData = document.querySelector(".data");
            for(let i = 0;i<json.length;i++){
                tData.innerHTML += `
                <tr>
                    <td>${json[i]["id"]}</td>
                    <td>${json[i]["dGoods"]}</td>
                    <td>${json[i]["dNum"]}</td>
                    <td>${json[i]["dStatus"]?"N":"F"}</td>
                    <td>${json[i]["dTime"]}</td>
                    <td>${json[i]["dAddress"]}</td>
                    <td>${json[i]["pStatus"]?"N":"F"}</td>
                </tr>
                `;
            }
        }
    })
})