<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="format-detection" content="telephone=no">

    <link rel="icon" href="../img/PitxintxuLogo.png" type="image/png">
    <title>Pitxintxu | Kontaktua</title>

    <link rel="stylesheet" href="../css/css-btsrp/bootstrap.min.css">
    <script src="../js-btsrp/bootstrap.bundle.min.js"></script>
    <script src="../jquery/jquery-3.7.1.min.js"></script>
    <script src="../jquery-ui/jquery-ui.min.js"></script>
    
    <link rel="stylesheet" href="../jquery-ui/jquery-ui.css">
    <link rel="stylesheet" href="../css/kontaktua.css">
    <link rel="stylesheet" href="../css/footer.css">
</head>

<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-white shadow-sm fixed-top">
        <div class="container-fluid">
            <a class="navbar-brand" href="../index.php">
                <img src="../img/PitxintxuBerria.png" />
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link" href="gu.php"><b>Gu</b></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="produktuak.php"><b>Produktuak</b></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" style="color: #5b3475" href="kontaktua.php"><b>Kontaktua</b></a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="map-section">
        <div class="info-box">
            <h2 class="store-title">Gure Denda</h2>
            <p class="store-address">San Frantzisko kalea, 27<br>20870 Elgoibar</p>
        </div>

        <div class="map-container">
            <iframe class="map"
                src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d5815.401087761556!2d-2.415854923880929!3d43.21576988061269!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd51d4304a5162f7%3A0x8caedca2af969571!2sPITXINTXU%20OPARI-DENDA!5e0!3m2!1ses!2ses!4v1746519612601!5m2!1ses!2ses"
                style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade">
            </iframe>
        </div>
    </div>

    <div class="additional-info container-fluid px-5 py-5">
        <div class="row mb-5">
            <div class="col-md-6 offset-md-3 text-center">
                <h2 class="section-title">ZALANTZARIK?</h2>
                <p class="ftmenu">
                    Ez kezkatu gurekin harremanetan jartzeko. Hemen gaude laguntzeko gure produktu edo
                    zerbitzuei buruzko edozein kontsulta izanez gero.
                </p>
            </div>
        </div>

        <div class="row text-center contact-options">
            <div class="col-md-4 mb-4">
                <div class="contact-box">
                    <h3 class="contact-title">DEITU</h3>
                    <p class="contact-data"><a href="tel:+34 943 74 32 06" class="as">(+34) 943 74 32 06</a></p>
                </div>
            </div>
            <div class="col-md-4 mb-4">
                <div class="contact-box">
                    <h3 class="contact-title">E-Mail</h3>
                    <p class="contact-data"><a href="mailto:sarapitxintxu@gmail.com"
                            class="as">sarapitxintxu@gmail.com</a></p>
                </div>
            </div>
            <div class="col-md-4 mb-4">
                <div class="contact-box">
                    <h3 class="contact-title">IDATZI</h3>
                    <p class="contact-data"><a href="https://wa.me/34943743206" target="_blank" class="as">Prest gaude
                            zure galderak irakurtzeko!</a></p>
                </div>
            </div>
        </div>
    </div>

    <div class="container text-center mt-5 mb-5">
        <h2 class="section-title">Galdera ohikoenak</h2>
        <div id="accordion">
            <h3>Produktu bat itzuli daiteke?</h3>
            <div>
                <p>Bai, produktu bat itzultzeko aukera dago, betiere erosketaren dataz geroztik hilabete bat baino gehiago igaro ez bada. Baldintza hau betetzen bada, arazorik gabe egingo da itzulera.</p>
            </div>

            <h3>Inprimaketak eta fotokopiak egiten dira?</h3>
            <div>
                <p>Ez, barkatu, baina ez dugu inprimaketa edo fotokopia zerbitzurik eskaintzen gure dendan.</p>
            </div>

            <h3>Zein ordainketa-modu onartzen dira?</h3>
            <div>
                <p>Bizum bidez ordaintzea ez da posible. Hala ere, eskudirutan ordaindu daiteke, eta baita banku-txartelaren bidez ere, erraztasun osoz.</p>
            </div>

            <h3>Liburu zehatz bat eskatu daiteke?</h3>
            <div>
                <p>Bai, noski. Bezeroek nahi duten liburu zehatza eskatzeko aukera dute. Ahalik eta azkarren lortzen saiatuko gara, eta eskuragarri dagoenean abisatuko dizugu.</p>
            </div>
        </div>
    </div>

    <div class="container" style="text-align: center; font-size: 18px">
        <p>Hemen ez dagoen galderaren bat baduzu, ez izan zalantzarik guri galdetzeko.</p>
    </div>

    <?php include 'footer.php' ?>

    <script>
        $(function() {
            $("#accordion").accordion({
                heightStyle: "content",
                collapsible: true,
                active: false,
                icons: {
                    header: "ui-icon-plus",
                    activeHeader: "ui-icon-minus"
                }
            });
        });
  </script>
</body>

</html>