function updateOrder() {
    const TAXRATE = 0.0925;
    const DONUTPRICE = 0.5;
    const numCakeDonuts = parseInt(document.getElementById("cakedonuts").value);
    const numGlazedDonuts = parseInt(document.getElementById("glazeddonuts").value);

    const subTotal = (numCakeDonuts + numGlazedDonuts) * DONUTPRICE;
    const tax = subTotal * TAXRATE;
    const total = subTotal + tax;
    document.getElementById("subtotal").value = "$" + subTotal.toFixed(2);
    document.getElementById("tax").value = "$" + tax.toFixed(2);
    document.getElementById("total").value = "$" + total.toFixed(2);
}

function placeOrder(form) {
    const name = document.getElementById('name').value;
    const minutes = document.getElementById('pickupminutes').value;

    if (name == "") {
        alert("I'm sorry but you must provide your name before submitting an order.");
        return;
    }

    if (isNaN(minutes)) {
        alert("I'm sorry but you must provide the number of minutes until pick‑up" +
            " before submitting an order.");
        console.log(minutes);
        return;
    }

    alert('Successfully placed order!')
    form.submit();
}