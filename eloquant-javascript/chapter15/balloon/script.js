function resizeBalloon(e) {
    const balloon = document.getElementById('balloon');
    switch (e.keyCode) {
        case 38: {  // up arrow
            const size = parseInt(window.getComputedStyle(balloon).getPropertyValue('font-size'));
            if (size >= 200) {
                balloon.textContent = "💥";
                window.removeEventListener("keydown", resizeBalloon);
            }

            balloon.style.fontSize = (1.1 * size) + "px";
            balloon.style.margin = "auto";
            break;
        }

        case 40: {  // down arrow
            const size = parseInt(window.getComputedStyle(balloon, null).getPropertyValue('font-size'));
            if (size <= 10) return;
            balloon.style.fontSize = (0.9 * size) + "px";
            break;
        }
    }
}

window.addEventListener("keydown", resizeBalloon);