<!DOCTYPE html>
<html>
  <head>
    <title>StarBuzz Coffee</title>
    <meta charset="utf-8" />
    <link type="text/css" rel="stylesheet" href="css/style.css" />
  </head>

  <body>
    <!-- header: banner of page -->
    <jsp:include page="/page-template/header.html"></jsp:include>

    <!-- navigate bar -->
    <nav>
      <ul>
        <li class="selected"><a href="index.jsp">HOME</a></li>
        <li><a href="blog.jsp">BLOG</a></li>
        <li><a href="">INVENTIONS</a></li>
        <li><a href="">RECIPES</a></li>
        <li><a href="">LOCATIONS</a></li>
      </ul>
    </nav>

    <div id="table-container">
      <div id="table-row">
        <!-- product column: information about drinks -->
        <jsp:include page="/page-template/products.html"></jsp:include>

        <!-- main column: content of home page -->
        <section id="main">
          <h1>QUALITY COFFEE, QUALITY CAFFEINE</h1>
          <p>
            At Starbuzz Coffee, we are dedicated to filling all your caffeine
            needs through our quality coffees and teas. Sure, we want you to
            have a great cup of coffee and a great coffee experience as well,
            but we're the only company that actively monitors and optimizes
            caffeine levels. So stop by and fill your cup, or order online with
            our new Bean Machine online order form, and get that quality
            Starbuzz coffee that you know will meet your caffeine standards.
          </p>
          <p>
            And, did we mention <em>caffeine</em>? We've just started funding
            the guys doing all the wonderful research at the
            <a
              href="http://buzz.wickedlysmart.com"
              title="Read all about caffeine on the Buzz"
              >Caffeine Buzz</a
            >. If you want the latest on coffee and other caffeine products,
            stop by and pay them a visit.
          </p>
          <h1>OUR STORY</h1>
          <p>
            "A man, a plan, a coffee bean". Okay, that doesn't make a
            palindrome, but it resulted in a damn good cup of coffee. Starbuzz's
            CEO is that man, and you already know his plan: a Starbuzz on every
            corner.
          </p>
          <p>
            In only a few years he's executed that plan and today you can enjoy
            Starbuzz just about anywhere. And, of course, the big news this year
            is that Starbuzz teamed up with Head First readers to create
            Starbuzz's Web presence, which is growing rapidly and helping to
            meet the caffeine needs of a whole new set of customers.
          </p>
          <h1>STARBUZZ COFFEE BEVERAGES</h1>
          <p>
            We've got a variety of caffeinated beverages to choose from at
            Starbuzz, including our
            <a href="beverages.html#house" title="House Blend">House Blend</a>,
            <a href="beverages.html#mocha" title="Mocha Cafe Latte"
              >Mocha Cafe Latte</a
            >,
            <a href="beverages.html#cappuccino" title="Cappuccino">Cappuccino</a
            >, and a favorite of our customers,
            <a href="beverages.html#chai" title="Chai Tea">Chai Tea</a>.
          </p>
          <p>
            We also offer a variety of coffee beans, whole or ground, for you to
            take home with you. Order your coffee today using our online
            <a href="form.html">Bean Machine</a>, and take the Starbuzz Coffee
            experience home.
          </p>
        </section>

        <!-- aside column: advertisement -->
        <jsp:include page="/page-template/ad.html"></jsp:include>
      </div>
    </div>

    <!-- footer: more information -->
    <jsp:include page="/page-template/footer.html"></jsp:include>
  </body>
</html>
