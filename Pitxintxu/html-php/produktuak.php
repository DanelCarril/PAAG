<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="format-detection" content="telephone=no">

    <link rel="icon" href="../img/PitxintxuLogo.png" type="image/png">
    <title>Pitxintxu | Produktuak</title>

    <link rel="stylesheet" href="../css/css-btsrp/bootstrap.min.css">
    <script src="../js-btsrp/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="../css/produktuak.css">
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
                    <li class="nav-item produktuak">
                        <a class="nav-link" style="color: #5b3475" href="produktuak.php"><b>Produktuak</b></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="kontaktua.php"><b>Kontaktua</b></a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Contenedor del toast -->
    <div class="toast-container position-fixed top-0 end-0 p-3" style="top: 62px; z-index: 1100;">
        <div id="infoToast" class="toast show" role="alert" aria-live="assertive" aria-atomic="true">
            <div class="toast-header bg-warning text-dark">
                <strong class="me-auto">Ohar Garrantzitsua</strong>
                <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
            </div>
            <div class="toast-body">
                Kaixo Zuek! Orrialde honetan ez duzu produktu edo katalogo zehatzik aurkituko, eskaintzen ditugun produktu moten ikuspegi orokorra baizik. 
                Artikulu zehatzak ezagutzeko, ongietorri <a href="kontaktua.php" style="text-decoration: underline; color: inherit;">gure dendara</a> edo jarri gurekin harremanetan.
            </div>
        </div>
    </div>

    <h2 class="section-title" id="liburuak">Dendan aurkitu dezakezun produktuak</h2>

    <!-- Productos -->
    <section id="productos" class="productos">
        <div class="producto-container">
            <!-- Producto: Libros -->
            <div class="producto" data-categoria="libros" onmouseover="startCarousel(this)" onmouseout="stopCarousel(this)">
                <div class="producto-card">
                    <div class="producto-img">
                        <!-- Carrusel de imágenes -->
                        <div id="carouselLibros" class="carousel slide" data-bs-interval="2000">
                            <div class="carousel-inner">
                                <div class="carousel-item active">
                                    <img src="../img/liburuak.jpg" class="d-block w-100" alt="Libros">
                                </div>
                                <div class="carousel-item">
                                    <img src="../img/liburuak_portada.jpg" class="d-block w-100" alt="Libros">
                                </div>
                                <div class="carousel-item">
                                    <img src="../img/liburuak_alboka.jpg" class="d-block w-100" alt="Libros">
                                </div>
                                <div class="carousel-item">
                                    <img src="../img/liburuak_pitxintxu.jpg" class="d-block w-100" alt="Libros">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="producto-info">
                        <h3>Liburuak</h3>
                        <p>Haur eta helduentzako liburu bereziak, euskaraz eta gaztelaniaz.</p>
                        <button class="ver-subproductos-btn">Gehiago</button>
                        <div class="subproductos">
                            <ul>
                                <li>Denetariko nobelak</li>
                                <li>Ipuinak</li>
                                <li>Nobela grafikoak</li>
                                <li>Komikiak</li>
                                <li>...</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Producto: Material Escolar -->
            <div class="producto" data-categoria="material" onmouseover="startCarousel(this)" onmouseout="stopCarousel(this)">
                <div class="producto-card">
                    <div class="producto-img">
                        <!-- Carrusel de imágenes -->
                        <div id="carouselMaterial" class="carousel slide" data-bs-interval="2000">
                            <div class="carousel-inner">
                                <div class="carousel-item active">
                                    <img src="../img/eskolako_materiala.jpg" class="d-block w-100" alt="Material Escolar">
                                </div>
                                <div class="carousel-item">
                                    <img src="../img/koaderno.jpg" class="d-block w-100" alt="Material Escolar">
                                </div>
                                <div class="carousel-item">
                                    <img src="../img/margoak.jpg" class="d-block w-100" alt="Material Escolar">
                                </div>
                                <div class="carousel-item">
                                    <img src="../img/margoak_estuche2.jpg" class="d-block w-100" alt="Material Escolar">
                                </div>
                                <div class="carousel-item">
                                    <img src="../img/posca_marcador.jpg" class="d-block w-100" alt="Material Escolar">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="producto-info">
                        <h3>Eskolako materiala</h3>
                        <p>Kalitatezko materiala ikasle eta irakasleentzat, erabiltzeko prest.</p>
                        <button class="ver-subproductos-btn">Gehiago</button>
                        <div class="subproductos">
                            <ul>
                                <li>Koadernoak</li>
                                <li>Arkatzak</li>
                                <li>Borragomak</li>
                                <li>Margoak</li>
                                <li>...</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Producto: Juguetes -->
            <div class="producto" data-categoria="juguetes" onmouseover="startCarousel(this)" onmouseout="stopCarousel(this)">
                <div class="producto-card">
                    <div class="producto-img">
                        <!-- Carrusel de imágenes -->
                        <div id="carouselJuguetes" class="carousel slide" data-bs-interval="2000">
                            <div class="carousel-inner">
                                <div class="carousel-item active">
                                    <img src="../img/jostailuak.jpg" class="d-block w-100" alt="Juguetes">
                                </div>
                                <div class="carousel-item">
                                    <img src="../img/panpinak.jpg" class="d-block w-100" alt="Juguetes">
                                </div>
                                <div class="carousel-item">
                                    <img src="../img/jostailuak2.jpg" class="d-block w-100" alt="Juguetes">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="producto-info">
                        <h3>Jostailuak</h3>
                        <p>Zure txikien ametsak betetzeko jostailuak, dibertigarriak eta hezigarriak.</p>
                        <button class="ver-subproductos-btn">Gehiago</button>
                        <div class="subproductos">
                            <ul>
                                <li>Panpinak</li>
                                <li>Puzzleak</li>
                                <li>Joko didaktiko eta pedagogikoak</li>
                                <li>...</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Producto: Accesorios -->
            <div class="producto" data-categoria="accesorios" onmouseover="startCarousel(this)" onmouseout="stopCarousel(this)">
                <div class="producto-card">
                    <div class="producto-img">
                        <!-- Carrusel de imágenes -->
                        <div id="carouselAccesorios" class="carousel slide" data-bs-interval="2000">
                            <div class="carousel-inner">
                                <div class="carousel-item active">
                                    <img src="../img/anartxy_bitxiak.jpg" class="d-block w-100" alt="Accesorios">
                                </div>
                                <div class="carousel-item">
                                    <img src="../img/zior_bitxiak.jpg" class="d-block w-100" alt="Accesorios">
                                </div>
                                <div class="carousel-item">
                                    <img src="../img/bisuteria_pitxintxu.jpg" class="d-block w-100" alt="Accesorios">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="producto-info">
                        <h3>Bisuteria</h3>
                        <p>Zure estiloa nabarmentzeko bisuteria ederrak, kalitatezko diseinuak.</p>
                        <button class="ver-subproductos-btn">Gehiago</button>
                        <div class="subproductos">
                            <ul>
                                <li>Belarritakoak</li>
                                <li>Lepokoak</li>
                                <li>...</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Producto: Otros -->
                        <!-- Producto: Otros -->
            <div class="producto" data-categoria="otros" onmouseover="startCarousel(this)" onmouseout="stopCarousel(this)">
                <div class="producto-card">
                    <div class="producto-img">
                        <!-- Carrusel de imágenes -->
                        <div id="carouselOtros" class="carousel slide" data-bs-interval="2000">
                            <div class="carousel-inner">
                                <div class="carousel-item active">
                                    <img src="../img/maleta.jpg" class="d-block w-100" alt="Otros Productos">
                                </div>
                                <div class="carousel-item">
                                    <img src="../img/mochila.jpg" class="d-block w-100" alt="Otros Productos">
                                </div>
                                <div class="carousel-item">
                                    <img src="../img/bolsas_calle.jpg" class="d-block w-100" alt="Otros Productos">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="producto-info">
                        <h3>Bestelakoak</h3>
                        <p>Egunerokoan lagungarri diren produktuak</p>
                        <button class="ver-subproductos-btn">Gehiago</button>
                        <div class="subproductos">
                            <ul>
                                <li>Maletak</li>
                                <li>Aterkiak</li>
                                <li>Botilak</li>
                                <li>...</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </section>

    <?php include 'footer.php' ?>

    <script src="../js/produktuak.js"></script>

</body>

</html>

