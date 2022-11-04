<#macro layout>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">

        <!-- Document -->
        <title>${pageName.name} | JWB-Racing</title>
        <meta name="description" content="This is the official website of JWB-Racing.">
        <meta name="keywords" content="racing, sim-racing, cars, gt7,">
        <meta name="author" content="JWB-Racing | Team">
        <link rel="shortcut icon" href="/utils/img/favicon.png"/>
        <!-- Document -->

        <!-- CSS -->
        <link rel="stylesheet" href="https://unpkg.com/aos@next/dist/aos.css" />
        <link rel="stylesheet" href="/utils/css/admin-style.min.css">
        <!-- CSS -->

        <!-- JS -->
        <script src="/utils/js/hamburgerMenu.js" defer></script>
        <!-- JS -->

    </head>
    <body>
    <header>
        <div data-aos="slide-down" data-aos-duration="1500" class="main-picture">
            <div class="header">
                <div class="img">
                    <a href="/"><img alt="Logo_JWB-Racing" width="60px" height="auto" src="/utils/img/logo.png"></a>
                </div>
                <div>
                    <a href="/admin" class="title">
                        <h1>Admin-Panel</h1>
                    </a>
                </div>
            </div>
        </div>
    </header>
    <main>
        <#nested>
    </main>
    <footer>
        <div data-aos="fade-in" data-aos-duration="1500" class="footer-all">
            <div class="footer">
                <a href="/imprint">Imprint</a> <!-- Imprint -->
                <a href="/privacy">Privacy Policy</a> <!-- Privacy -->
                <a href="/conditions">Conditions</a> <!-- Conditions -->
            </div>
            <div class="footer-name">
                <p>&copy; 2022 - JWB-Racing</p>
            </div>
        </div>
    </footer>
    <script src="https://unpkg.com/aos@next/dist/aos.js"></script>
    <script>
        AOS.init();
    </script>
    </body>

</#macro>