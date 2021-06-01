const abook = document.querySelectorAll('.book')
for(const book of abook){
    book.addEventListener('touchstart',function(){
        book.style.backgroundColor = 'rgba(240, 240, 240, 0.5)'
    })
    book.addEventListener('touchend',function(){
        book.style.backgroundColor = '#fff'
    })
}
function toast(content){
    const div = document.createElement("div");
    div.classList.add("toast")
    div.innerText = content
    document.body.append(div)
    setTimeout(function(){
        document.body.removeChild(div)
    },2000)
}
function post(url,body){
    const form = new FormData();
    if(body){
        for(const [key,value] of Object.entries(body)){
            form.append(key,value)
        }
    }
    return fetch(url,{
        method: 'POST',
        body : form
    }).then(res=>res.json())
}
function get(url,body){
    let str = '?'
    if(body){
        for(const [key,value] of Object.entries(body)){
            str += key + '=' + value + '&'
        }
    }
    
    str = str.substr(0,str.length-1)
    return fetch(url+str).then(res=>res.json())
}
function getQueryVariable(variable)
{
       var query = window.location.search.substring(1);
       var vars = query.split("&");
       for (var i=0;i<vars.length;i++) {
               var pair = vars[i].split("=");
               if(pair[0] == variable){return decodeURI(pair[1]) }
       }
       return(false);
}