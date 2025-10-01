document.querySelectorAll('.ver-subproductos-btn').forEach(btn => {
    btn.addEventListener('click', (e) => {
        const productoCard = e.target.closest('.producto-card');
        const subproductos = productoCard.querySelector('.subproductos');

        if (productoCard.classList.contains('active')) {
            // Ocultar con animación
            subproductos.style.maxHeight = subproductos.scrollHeight + 'px'; // Asegura que el valor esté completo antes de colapsar
            requestAnimationFrame(() => {
                subproductos.style.maxHeight = '0px';
            });

            productoCard.classList.remove('active');
            e.target.textContent = "Gehiago";
        } else {
            // Mostrar con animación
            subproductos.style.maxHeight = subproductos.scrollHeight + 'px';

            productoCard.classList.add('active');
            e.target.textContent = "Itxi";
        }
    });
});

let carouselInstances = {};

function startCarousel(producto) {
    // Verifica si ya se ha creado una instancia del carrusel para este producto
    let carouselId = producto.querySelector('.carousel').id;

    // Si no existe una instancia del carrusel, la creamos
    if (!carouselInstances[carouselId]) {
        let carouselElement = producto.querySelector('.carousel');
        let carouselInstance = new bootstrap.Carousel(carouselElement, {
            interval: 2000 // Intervalo de 2 segundos
        });
        carouselInstances[carouselId] = carouselInstance;
        carouselInstance.cycle(); // Inicia el carrusel
    } else {
        carouselInstances[carouselId].cycle(); // Si ya existe la instancia, solo se inicia
    }
}

function stopCarousel(producto) {
    let carouselId = producto.querySelector('.carousel').id;

    if (carouselInstances[carouselId]) {
        carouselInstances[carouselId].pause(); // Detiene el carrusel
    }
}