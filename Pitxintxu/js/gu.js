document.addEventListener("DOMContentLoaded", function () {
            const elements = document.querySelectorAll(".animate-on-scroll");

            function checkVisibility() {
                elements.forEach(element => {
                    const rect = element.getBoundingClientRect();
                    if (rect.top < window.innerHeight && rect.bottom > 0) {
                        element.classList.add("visible");
                    } else {
                        element.classList.remove("visible");
                    }
                });
            }

            window.addEventListener("scroll", checkVisibility);

            checkVisibility();
        })

        const cards = document.querySelectorAll('.card');
        const modal = document.getElementById('infoModal');
        const modalText = document.getElementById('modalText');
        const modalTitle = document.getElementById('modalTitle');
        const closeBtn = document.querySelector('.modal .close');

        // Contenido personalizado para cada tarjeta (puedes modificarlo)
        const cardContent = {
            0: {
            title: "Euskarazko zerbitzua",
            text: "Gure zerbitzu guztiak euskaraz eskaintzen dira, gure hizkuntzaren normalizazioa sustatzeko."
            },
            1: {
            title: "Gertutasuna",
            text: "Bezeroarekiko hurbiltasuna eta arreta pertsonalizatua gure balore nagusien artean dago."
            },
            2: {
            title: "Kalitatezko materiala",
            text: "Erabiltzen ditugun materialak kalitate gorenekoak dira, iraunkortasuna eta erabilgarritasuna bermatzeko."
            },
            3: {
            title: "Liburu salmenta",
            text: "Euskarazko liburuen salmenta eta sustapena gure proiektuaren parte da."
            }
        };

        // Asigna evento de clic a cada card
        cards.forEach((card, index) => {
            card.addEventListener('click', () => {
            const { title, text } = cardContent[index] || {};
            modalTitle.textContent = title || "Información";
            modalText.textContent = text || "Descripción no disponible.";
            modal.classList.add('active');
            });
        });

        // Cerrar el modal al hacer clic en la X
        closeBtn.onclick = () => {
            modal.classList.remove('active');
        }

        // Cerrar al hacer clic fuera del contenido
        window.onclick = (e) => {
            if (e.target === modal) {
            modal.classList.remove('active');
            }
        }