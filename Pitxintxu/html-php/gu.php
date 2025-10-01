<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="format-detection" content="telephone=no">

    <link rel="icon" href="../img/PitxintxuLogo.png" type="image/png">
    <title>Pitxintxu | Gu</title>

    <link rel="stylesheet" href="../css/css-btsrp/bootstrap.min.css">
    <script src="../js-btsrp/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="../css/gu.css">
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
                        <a class="nav-link" style="color: #5b3475" href="gu.php"><b>Gu</b></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="produktuak.php"><b>Produktuak</b></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="kontaktua.php"><b>Kontaktua</b></a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <section class="hero ">
        <div class="hero-content">
            <h2 class="animate-on-scroll">Denda bat baino gehiago</h2>
        </div>
    </section>

    <section id="historia" class="historia">
        <div class="container historia-card">
            <div class="historia-imagen-lateral">
                <img src="../img/PitxintxuSarrera.png" alt="Entrada de la tienda">
            </div>
            <div class="historia-contenido">
                <h3><b>Pitxintxu 1978tik bizirik</b></h3>
                <p>
                    Pitxintxu Opari denda Marijose eta Izaskun Estibaritz Astarloa ahizpek sortua izan zen 1978ko
                    Apirilaren 22an (Liburu egunaren bezperan). Ordutik, 45 urte luzez bi ahizpek dendan jardun
                    izan dute lanean 2023ko uztailaren 15ean merezitako jubilazioa hartu arte.<br><br>
                    Ordutik, Sara Arriolak ekin dio dendaren jarduteari ilusioz eta gogo handiz. Dendan arukitu
                    daitezke haurrentzako jolasak, eskolako materiala, maletak, bitxiak, poltsak … eta Liburuak.<br>
                    Herrian irekita geratzen den liburu denda bakarra da eta gaur egungo teknologia korronte
                    berrien aurrean tinko mantentzen da.
                    Elgoibartik pasatzen baldin bazarete ez galdu denda honen xarma ikusteko aukera! 😊<br><br>
                    Zain izango zaituztet.
                </p>
            </div>
        </div>
    </section>

    <section class="valores">
        <div class="container">
            <h3>Helburuak</h3>
            <div class="cards">
                <div class="card animate-on-scroll">
                    <p>Euskarazko zerbitzua</p>
                </div>
                <div class="card animate-on-scroll">
                    <p>Gertutasuna</p>
                </div>
                <div class="card animate-on-scroll">
                    <p>Kalitatezko materiala</p>
                </div>
                <div class="card animate-on-scroll">
                    <p>Liburu salmenta</p>
                </div>
            </div>
        </div>
    </section>

    <hr class="hrp">
    
    <section class="equipo">
        <div class="container">
            <h3>Sara Arriola</h3>
            <div class="jefa">
                <img src="../img/Sara_Arriola.jpg">
                <p class="mt-3">Pitxintxuko burua</p>
                <blockquote>
                    “Irakurtzen duen haurra, pentsatuko duen heldua”
                </blockquote>
            </div>
        </div>
    </section>

    <?php include 'footer.php' ?>

    <!-- Modal reusable -->
    <div id="infoModal" class="modal">
        <div class="modal-content">
            <span class="close">&times;</span>
            <h2 id="modalTitle">Información</h2>
            <p id="modalText">Texto de ejemplo.</p>
        </div>
    </div>

    <script src="../js/gu.js"></script>
</body>
</html>