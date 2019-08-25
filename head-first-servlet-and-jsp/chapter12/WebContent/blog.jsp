<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
    <title>StarBuzz Coffee</title>
    <meta charset="utf-8" />
    <link type="text/css" rel="stylesheet" href="css/style.css" />
  </head>

  <body>
    <!-- header: banner of page -->
    <c:import url="/page-template/header.html"/>

    <!-- navigate bar -->
    <nav>
      <ul>
        <li><a href="index.jsp">HOME</a></li>
        <li class="selected"><a href="blog.jsp">BLOG</a></li>
        <li><a href="">INVENTIONS</a></li>
        <li><a href="">RECIPES</a></li>
        <li><a href="">LOCATIONS</a></li>
      </ul>
    </nav>

    <div id="table-container">
      <div id="table-row">
        <!-- product column: information about drinks -->
        <c:import url="/page-template/products.html"/>

        <!-- main column: blogs of page -->
        <section id="blog">
          <article>
            <header>
              <h1>Starbuzz meets social media</h1>
              <time datetime="2012-03-18">18/03/2012</time>
            </header>
            <p>
              Here at Starbuzz we're embracing the social media craze. In fact,
              we're going further than any of our competitors and we're very
              close to announcing a revolutionary new product that links your
              coffee drinking directly to your social network. Forget "checking
              in"; we're going way beyond that, and with this new product every
              sip of smooth, aromatic, hot Starbuzz blend is going to to be
              shared with your social network.
            </p>
            <p>
              Sound like science fiction? It's not; I'm already testing our
              final prototype social network cup as I write this, which links
              you, the drinker, right to your favorite social networks. We've
              made a huge investment to make this happen and we've created a
              reusable coffee cup complete with RFID, NFC, Bluetooth, and Wifi
              (not to mention a few more things the tech folks know about,
              because hey, I'm just the coffee guy).
            </p>
            <p>
              So, keep your eyes out for this amazing new cup. And I'll be
              releasing a video teaser soon to tell you all about this new
              invention, straight from Starbuzz Coffee.
            </p>
          </article>

          <article>
            <header>
              <h1>Starbuzz uses computer science</h1>
              <time datetime="2012-03-10">10/03/2012</time>
            </header>
            <p>
              Have you ever noticed how efficient a Starbuzz Coffee house is?
              The lines alway move fast, and despite the astronomical number of
              different drinks any customer can order, we have your drink up,
              hot (or cold if that's the way you want it) and ready in seconds.
              How do we do it?
            </p>
            <p>
              To pull this off, we take advantage of the latest and greatest in
              computer science. In fact, we train our staff to be one big
              distributed computer. The cashiers create the orders for the
              distributed computer, complete with your name and the drinks
              special instructions. Then our specialized drink makers grab the
              next cup and go about working on your order until it's finished.
            </p>
            <p>
              With this design, we are able to horizontally scale our operation
              any time we want. All we need to do is add more cashiers and drink
              makers (not to mention a fair amount of support staff you never
              see) as the customer flow grows.
            </p>
          </article>

          <article>
            <header>
              <h1>Most unique patron of the month</h1>
              <time datetime="2012-02-18">18/02/2012</time>
            </header>
            <p>
              Our most unique patron of the month award goes to a customer in
              Poulsbo, Washington, whose daily morning order is a "six-splenda,
              no-foam, 130-degree non-fat-soy latte, with the splenda stirred in
              before the milk is added." Do we have unique customers or what?
            </p>
          </article>
        </section>

        <!-- aside column: advertisement -->
        <c:import url="/page-template/ad.html"/>
      </div>
    </div>

    <!-- footer: more information -->
    <c:import url="/page-template/footer.html"/>
  </body>
</html>
