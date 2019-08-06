function animateHat() {
    let hat = document.getElementById('hat');
    let angle = Math.PI / 2;
    
    function animate(time, lastTime) {
        if (lastTime != null) {
            angle += (time - lastTime) * 0.003;
        }
        hat.style.top = (Math.sin(angle) * 150 + 300) + "px";
        hat.style.left = (Math.cos(angle) * 150 + 300) + "px";
        requestAnimationFrame(newTime => animate(newTime, time));
    }
    requestAnimationFrame(animate);
    console.log("what");
}

animateHat();