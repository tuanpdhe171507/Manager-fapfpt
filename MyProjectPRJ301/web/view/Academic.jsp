<%-- 
    Document   : Academic
    Created on : Feb 25, 2024, 4:40:35 PM
    Author     : G5 5590
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .text1{
                margin-top: 40px;
                margin-left: -60px;

            }
            .rectangle {
                width: 1230px;
                height: 50px;
                background-color: #CCCCCC;
                margin-left: -60px;
                margin-top: 20px;
                margin-bottom: 20px;
                margin-left: 120px;
                border-radius: 5px;
            }

            .cc{
                display: flex;
                justify-content: center;
            }
            .col-md-6 {
                width: 50%;
            }
            .cc{
                width: 100%;
            }

            .ht{
                width:450px;
                height: 190px;
                border: 1px solid #000;
                margin: 2px;
                margin-left: 100px;
                border-radius: 5px;
                box-shadow: 5px 5px 2px -2px rgb(200, 199, 199),
                    -5px -5px 2px -2px rgb(200, 199, 199),
                    5px -5px 2px -2px rgb(200, 199, 199),
                    -5px 5px 2px -2px rgb(200, 199, 199);
            }
            .ht1{
                width:750px;
                height: 190px;
                border: 1px solid #000;
                margin: 2px;
                margin-left: -120px;
                border-radius: 5px;
                box-shadow: 5px 5px 2px -2px rgb(200, 199, 199),
                    -5px -5px 2px -2px rgb(200, 199, 199),
                    5px -5px 2px -2px rgb(200, 199, 199),
                    -5px 5px 2px -2px rgb(200, 199, 199);
            }
            .additional-line {
                width: 100%;
                height: 1px;
                background-color:#000;
                margin-top: 30px;
            }
            .rec{
                width: 140px;
                height: 40px;
                background-color:  #6fa8dc;
                border-radius: 5px;
            }
            .text2{
                color: white;
                text-align: center;
            }
            .rec1{
                width: 340px;
                height: 40px;
                background-color: orange;
                border-radius: 5px;
                margin-top: -35px;
            }
            .text3{
                display: flex;
            }
        </style>
    </head>
    <body>
        <form action="">
            <div class="container">
                <div class="row cc">
                    <div class="col-md-6">
                        <h1 class="text1">FPT University Academic Portal</h1>
                    </div>
                    <div class="col-md-6">
                        <img src="data:image/jpeg;base64,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">

                    </div>
                </div>
            </div>  
            <div class="rectangle"></div>
            <div class="row cc">
                <div class="col-md-6">
                    <div class="ht">
                        <!-- Nội dung bên trong hình chữ nhật -->

                        <div class="rec">
                            <h2 class="text2">News</h2>
                        </div>


                    </div>
                </div>
                <div class="col-md-6">
                    <div class="ht1">

                        <!-- Nội dung bên trong hình chữ nhật -->
                        <div class="additional-line"></div>
                        <div class="rec1">
                            <h2 class="text2">Academic Information</h2>
                        </div>
                        <div><h5>Information Access(Tra cứu thông tin)</h5></div>
                        <div class="text3">
                            <h7><a href="timetable">Weekly Timetable</a></h7> <h7>(Thời khóa biểu từng tuần)</h7>
                            <h7><a href="">Academic Transcript</a></h7> <h7>(Academic Transcript)</h7>
                        </div>
                    </div>
                </div>
            </div>


        </form>

    </body>
</html>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

