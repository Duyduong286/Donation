# Báo cáo thực hành Hosting Web Server
## Sinh viên thực hiện
* Họ và tên: Nguyễn Duy Đường
* MSSV: 19020266
## 1. Cài đặt NodeJS
* Truy cập trang web [NodeJS](https://nodejs.org/en/download/)
* Tải xuống phiên bản NodeJS dành cho Windows (node-v16.17.0-x64.msi)
* Chạy file tải xuống để tiến hành cài đặt
## 2. Code kiểm tra server
*<Code được soạn thảo và chạy trên Visual Studio Code>*
* Khởi động Visual Studio Code và tạo 2 file mới là main.js và index.html
* Trong file main.js thực hiện kết nối và lắng nghe từ server

        const http = require('http')
        const fs = require('fs')
        const port = 8000

        const server = http.createServer(function(req, res) {
            res.writeHead(200, {'Content-Type': 'text/html'})
            fs.readFile('index.html', function(error, data) {
                if (error) {
                    res.writeHead(404)
                    res.write('Server Error')
                } else {
                    res.write(data)
                }
                res.end()
            })
        })

        server.listen(port, function(error) {
            if (error) {
                console.log("Can't listening on port " + port, error)
            } else {
                console.log('Server is listening on port ' + port)
            }
        })
* Trong file index.html ta tạo một file html đơn giản.
  
        <!DOCTYPE html>
        <html>
        <head>
        <title>Welcome!</title>
        </head>
        <body>

        <h1 style="color:red; font-size: 20px;">Success!</h1>

        </body>
        <!-- <script type="text/javascript" src="main.js"></script> -->
        </html>
* Kết quả sau khi run và build code 

![week1.png](attachment:9f1eb79d-decb-447a-a6b8-9bb30f24edb3.png)
