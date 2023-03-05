var data = null
function update(obj) {
    // var userid = document.getElementsByName("sex-edit");
    <!--                    String id,String imageUrl,String url,String title,String extra-->
    // window.alert(document.getElementById("mypicurl").value);
    data = {id: document.getElementById("myid").value,
        imageurl: document.getElementById("mypicurl").value,
        url: document.getElementById("myurl").value,
        title: document.getElementById("mytitle").value,
        extra: document.getElementById("myextra").value
    };


    $.ajax({
        type: "POST",
        url: "/config/homeupdatea",
        contentType: "application/json; charset=utf-8",
        dataType: 'json',
        data: JSON.stringify(data),
        async: false,
        success: function (msg) {
            window.alert(msg);
        }
    });

}