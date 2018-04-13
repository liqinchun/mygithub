<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>
        百度搜索引擎调用
    </title>
    <style>
        #q {width: 300px; height: 30px; padding: 5px; border:1px solid #f90; font-size: 16px;}
        #ul1 {border:1px solid #f90; width: 310px; margin: 0;padding: 0; display: none;}
        li a { line-height: 30px; padding: 5px; text-decoration: none; color: black; display: block;}
        li a:hover{ background: #f90; color: white; }
    </style>
    <script>
        function maiov(data) {

            var oUl = document.getElementById('ul1');
            var html = '';
            if (data.s.length) {
                oUl.style.display = 'block';
                for (var i=0; i<data.s.length; i++) {
                    html += '<li><a target="_blank" href="http://www.baidu.com/s?wd='+data.s[i]+'">'+ data.s[i] +'</a></li>';
                }
                oUl.innerHTML = html;
            } else {
                oUl.style.display = 'none';
            }

        }
        window.onload = function() {

            var oQ = document.getElementById('q');
            var oUl = document.getElementById('ul1');

            oQ.onkeyup = function() {

                if ( this.value != '' ) {
                    var oScript = document.createElement('script');
                    oScript.src = 'http://suggestion.baidu.com/su?wd='+this.value+'&cb=maiov';
                    document.body.appendChild(oScript);
                } else {
                    oUl.style.display = 'none';
                }

            }

        }
    </script>
</head>

<body>
<input type="text" id="q" />
<ul id="ul1"></ul>
</body>
</html>