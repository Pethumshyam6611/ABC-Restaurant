<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <title>ABC Restaurant</title>
  <meta name="description" content="">
  <meta name="keywords" content="">

  <!-- Favicons -->
  <link href="assets/img/favicon.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">
  <!-- Load icon library -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

  <!-- Fonts -->
  <link href="https://fonts.googleapis.com" rel="preconnect">
  <link href="https://fonts.gstatic.com" rel="preconnect" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Satisfy:wght@400&display=swap" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="assets/vendor/aos/aos.css" rel="stylesheet">
  <link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
  <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">
  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

  <!-- Bootstrap JS (including Popper.js) -->
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
  

  <!-- Main CSS File -->
  <link href="assets/css/main.css" rel="stylesheet">
  <!-- Swiper CSS -->
  <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css">

  <!-- Swiper JS -->
  <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>

  </head>




<body class="index-page">
<% 
Integer userId = (Integer) session.getAttribute("userId");%>

<%
    
 String username = (String) session.getAttribute("username"); 
 String email = (String) session.getAttribute("email");

%>

<% 
%>
	
<script>
    	
    		var userId = <%= userId %>;
    		
</script>
	
	
	
	
	

  <header id="header" class="header fixed-top">
    <div class="topbar d-flex align-items-center">
      <div class="container d-flex justify-content-end justify-content-md-between">

      
      </div>
    </div><!-- End Top Bar -->

    <div class="branding d-flex align-items-cente">

      <div class="container position-relative d-flex align-items-center justify-content-between">
        <a href="index.html" class="logo d-flex align-items-center">
          <h1 class="sitename">ABC Restaurant</h1>
        </a>

        <nav id="navmenu" class="navmenu">
          <ul>
            <li><a href="#hero" class="active">Home</a></li>
            <li><a href="#about">About</a></li>
            <li><a href="#menu">Menu</a></li>
            <li><a href="#events">Offers</a></li>
            <li><a href="#facilities">Facilities</a></li>
            <li><a href="#gallery">Gallery</a></li> 
            <li><a href="#contact">Contact</a></li>
            
            
            
            
          </ul>
          <i class="mobile-nav-toggle d-xl-none bi bi-list"></i>
        </nav>
      <a href="#" data-bs-toggle="modal" data-bs-target="#cartModal">
      <i class="bi bi-cart-fill" style="font-size: 1.5rem; color: white;"></i>
      <span class="badge bg-danger" id="cart-count" style="background-color: yellowgreen  !important;">0</span>
      <a href="#" id="signup-button" class="btn" data-bs-toggle="modal" data-bs-target="#loginModal" style="color: whitesmoke; background-color: yellowgreen; border-radius: 5px;">
      <% if (username != null && !username.isEmpty()) { %>
        Wellcome, <%= username %>
      <% } else { %>
        Sign Up
      <% } %>
      </a>
      <% if (username != null && !username.isEmpty()) { %>
                        <!-- Logout Button -->
      <a href="logout?fromPage=mainPage" class="btn btn-outline-danger" style="color: whitesmoke; background-color: red; border-radius: 5px; margin-left: 10px;">
       Logout
      </a>
      <% } %>  
      </div>
	 
    </div>
  </header>

  <main class="main">

    <!-- Hero Section -->
    <section id="hero" class="hero section dark-background">

      <div id="hero-carousel" class="carousel slide carousel-fade" data-bs-ride="carousel" data-bs-interval="5000">

        <div class="carousel-item active">
          <img src="assets/img/hero-carousel/side-view-man-making-delicious-tacos.jpg" alt="">
          <div class="carousel-container">
            <h2 style="font-weight: 800;"><span>ABC</span> RESTAURANT</h2>
            <p>Discover a world of flavor at ABC Restaurant, where every meal is a celebration. Our menu, crafted with fresh, local ingredients, offers something delicious for every palate. Whether you're here for a casual lunch or a special dinner, our friendly staff and inviting atmosphere will make your experience memorable. Join us at ABC Restaurant and savor the difference. We can't wait to welcome you!</p>
            <div>
              <a href="#menu" class="btn-get-started" style="border-radius: 0;">Explore Menu</a>
            </div>
          </div>
        </div><!-- End Carousel Item -->
      </div>

    </section><!-- /Hero Section -->
    
    
    
<br>
<br>

<!-- About Us Section -->
<section id="about" class="about section light-background">

      <div class="container">
<!-- Section Title -->
			<div class="container section-title" data-aos="fade-up">
  				<hr style="width: 7%; height: 3px; background-color: #433f39; margin: 0 auto;">
 				<br>
  				<h1 style=" font-weight: 800;">ABOUT <span style=" color: yellowgreen">US</span></h1>
  				<p>Welcome to our restaurant, where exceptional dining meets a memorable experience.<br> Located in a cozy setting, we offer a diverse menu of freshly made dishes.Our dedicated staff ensures attentive service and a welcoming atmosphere.</p>
        </div><!-- End Section Title -->
        <div class="row gy-4">
          <div class="row align-items-center" data-aos="fade-up" data-aos-delay="100" >
            <div class="col-lg-4">
            <img src="assets/img/7c2d1b83-a2b0-4c41-bc59-84b1034743cc.png" class="img-fluid" alt="" style="width: 100%; height: 515px;" >
            </div>
            <br>
            <br>
            <div class="col-lg-4" style="justify-content: space-between;">
            <img src="assets/img/63f98c60-5730-4c67-9f35-cec8d4fc16fb.png" class="img-fluid" alt="">
            <br>
            <br>
            <br>
            <img src="assets/img/951860dc-0bfc-4110-9a53-bd906a87a4ee.png" class="img-fluid" alt="">
            </div>
            <br>
            <div class="col-lg-4">
              <img src="assets/img/delicious-pasta-plate.jpg" class="img-fluid" alt="">
              </div>  
          </div>
        </div>
      </div>
</section>
<!-- /About Section -->

    <br>
    <br>
    
<!-- Services Section -->
    <section id="why-us" class="why-us section" style=" background-color: yellowgreen;">
     <!-- Section Title -->
    <div class="container section-title" data-aos="fade-up">
  	<hr style="width: 7%; height: 3px; background-color: #ffffff; margin: 0 auto;">
  	<br>
  	<h1 style=" font-weight: 800;">OUR <span style="color: white;">SERVICES</span></span></h1>
  	<p>At our restaurant, we offer a diverse menu of freshly prepared dishes, attentive service, and an elegant atmosphere.<br> Whether for a special occasion or a casual meal, we aim to make your dining experience memorable.</p>	
  	</div><!-- End Section Title -->
	
	
    <div class="container">

        <div class="row gy-4">

          <div class="col-lg-4" data-aos="fade-up" data-aos-delay="100";>
            <div class="card-item">
              <span>01</span>
              <h4><a href="" class="stretched-link">Exquisite Cuisine</a></h4>
              <p>Indulge in a culinary journey with our handpicked selection of mouth-watering dishes, crafted to perfection by our top chefs.</p>
            </div>
          </div><!-- Card Item -->

          <div class="col-lg-4" data-aos="fade-up" data-aos-delay="200";>
            <div class="card-item">
              <span>02</span>
              <h4><a href="" class="stretched-link">Elegant Dining Ambiance</a></h4>
              <p>Experience dining like never before in our beautifully designed spaces, where every meal is a celebration of good taste.</p>
            </div>
          </div><!-- Card Item -->

          <div class="col-lg-4" data-aos="fade-up" data-aos-delay="300";>
            <div class="card-item">
              <span>03</span>
              <h4><a href="" class="stretched-link">Exclusive Services</a></h4>
              <p>We offer more than just food,enjoy our personalized services, tailored to create memorable experiences for every guest.</p>
            </div>
          </div><!-- Card Item -->

        </div>

      </div>

    </section>
<!-- /Services Section -->
<br>
<br>


<!-- Menu Section -->
<section id="menu" class="menu section">

<!-- Section Title -->
  <div class="container section-title" data-aos="fade-up">
    <hr style="width: 7%; height: 3px; background-color: #433f39; margin: 0 auto;">
    <br>
    <h1 style=" font-weight: 800;">OUR<span style=" color: yellowgreen">MENU</span></h1>
    <div class="menut" style="display: flex; justify-content: flex-end;">
      <form class="d-flex" role="search">
        <input id="searchInput" class="form-control me-2 my-input" type="search" placeholder="Search" aria-label="Search" style="outline: 2px solid yellowgreen; font-family: poppins;">
        <button class="btn" type="button" style="background-color: yellowgreen; color: white;">Search</button>
      </form>
    </div>
  </div>
  <!-- End Section Title -->
  <div class="container isotope-layout" data-default-filter="*" data-layout="masonry" data-sort="original-order">
    <section id="menu-filter" class="section py-5">
      <div class="container">
        <!-- Filter Buttons -->
        <div class="row mb-4">
          <div class="col text-center">
            <button class="btn filter-btn" data-category="all" Style="Background-color:yellowgreen;color: white; border-radius:40px">All</button>
            <button class="btn filter-btn" data-category="Main Course" Style="Background-color:yellowgreen;color: white; border-radius:40px">Main Course</button>
            <button class="btn filter-btn" data-category="Drinks" Style="Background-color:yellowgreen;color: white; border-radius:40px">Drinks</button>
            <button class="btn filter-btn" data-category="Dessert" Style="Background-color:yellowgreen;color: white; border-radius:40px">Dessert</button>
          </div>
        </div>

        <!-- Menu Items -->
        <div id="popular-dishes" class="row">
          <c:forEach var="menu" items="${menu}">
            <div class="col-md-3 mb-2 menu-item" data-category="${menu.category}">
              <div class="card shadow-sm text-center h-100">
                <img src="${menu.image}" class="card-img-top img-fluid" alt="${menu.productName}" style="max-height: 200px; object-fit: cover;">
                <div class="card-body">
                  <h5 class="card-title">${menu.productName}</h5>
                  <p class="font-weight-bold text-success">Rs.${menu.price}</p>
                  <p class="card-text">${menu.description}</p>
                  <button class="btn btn-primary add-to-cart" data-id="${menu.productID}" data-name="${menu.productName}" data-price="${menu.price}" style="background-color: #9ACD32; border-color: #9ACD32;">Add To Cart</button>
                </div>
              </div>
            </div>
          </c:forEach>
        </div>
      </div>
    </section>
<!-- End Menu Filter Section -->

<!-- Cart Modal -->
        <div class="modal fade" id="cartModal" tabindex="-1" aria-labelledby="cartModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg">
                <div class="modal-content border-0 rounded-3" style="background-color: #fff; color: #333;">
                    <div class="modal-header border-bottom-0">
                        <h5 class="modal-title" id="cartModalLabel" style="color: #9ACD32;">Your Cart</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <table class="table table-striped">
                            <thead class="table-light" style="background-color: #9ACD32; color: white;">
                                <tr>
                                    <th>Product Name</th>
                                    <th>Quantity</th>
                                    <th>Price</th>
                                    <th>Total</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody id="cart-items">
                                <!-- Cart items will be dynamically loaded here -->
                            </tbody>
                        </table>
                        <h5 class="mt-3" style="color: #333;">Total: Rs. <span id="cart-total" style="color: #9ACD32;">0.00</span></h5>
                        <div id="cart-summary" class="mt-3">
                            <!-- Cart summary will be dynamically loaded here -->
                        </div>
                    </div>
                    <div class="modal-footer border-top-0">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary" id="checkout-button">Proceed to Checkout</button>
                    </div>
                </div>
            </div>
        </div>
		
        <!-- Hidden Checkout Form -->
        <form id="checkout-form" action="oder" method="post" style="display: none;">
        	<input type="hidden" name="source" value="mainPage">
            <input type="hidden" name="action" value="new">
            <input type="hidden" name="foodNamewithQT" id="hidden-foodNamewithQT">
            <input type="hidden" name="userIdp" value="6" id="hidden-userIdp">
            <input type="hidden" name="type" id="hidden-type" value="dine in">
            <input type="hidden" name="status" id="hidden-status" value="pending">
            <input type="hidden" name="totalPrice" id="hidden-totalPrice">
            <input type="hidden" name="datetime" id="hidden-datetime">
        </form>
        
    </section>
    
<script>
    document.addEventListener('DOMContentLoaded', function() {
    // Assuming userId is obtained from the session in your JSP and set in a JavaScript variable
    var userId = <%= (userId != null) ? userId : -1 %>; // Replace this with actual user ID, or -1 if not logged in

    var cartItems = {};
    var cartCountElement = document.getElementById('cart-count');
    var cartTotalElement = document.getElementById('cart-total');
    var cartItemsElement = document.getElementById('cart-items');
    var cartSummaryElement = document.getElementById('cart-summary');
    var checkoutForm = document.getElementById('checkout-form');
    var checkoutButton = document.getElementById('checkout-button');

    // Function to update cart display
    function updateCart() {
        cartItemsElement.innerHTML = '';
        cartSummaryElement.innerHTML = ''; // Clear previous summary
        var total = 0;
        var count = 0;
        var summary = '';

        for (var menuID in cartItems) {
            if (cartItems.hasOwnProperty(menuID)) {
                var item = cartItems[menuID];
                total += item.total;
                count += item.quantity;

                var row = document.createElement('tr');
                
                // Generate options for quantity dropdown
                var options = '';
                for (var i = 1; i <= 10; i++) {
                    options += '<option value="' + i + '"' + (item.quantity === i ? ' selected' : '') + '>' + i + '</option>';
                }

                row.innerHTML = 
                    '<td>' + item.name + '</td>' +
                    '<td><select class="form-select item-quantity" data-id="' + menuID + '">' + options + '</select></td>' +
                    '<td>Rs. ' + item.price.toFixed(2) + '</td>' +
                    '<td>Rs. ' + item.total.toFixed(2) + '</td>' +
                    '<td><button class="btn btn-danger btn-sm remove-item" data-id="' + menuID + '">Remove</button></td>';

                cartItemsElement.appendChild(row);

                // Build the summary string
                summary += item.name + ' (' + item.quantity + '), ';
            }
        }

        cartCountElement.textContent = count;
        cartTotalElement.textContent = total.toFixed(2);

      // Display the summary of selected products
        if (summary) {
            summary = summary.slice(0, -2); // Remove trailing comma and space
            cartSummaryElement.innerHTML = '<h5>Selected Products: ' + summary + '</h5>';
        }

        var quantitySelectors = document.querySelectorAll('.item-quantity');
        quantitySelectors.forEach(function(select) {
            select.addEventListener('change', function(e) {
                var menuID = e.currentTarget.getAttribute('data-id');
                var newQuantity = parseInt(e.currentTarget.value, 10);
                cartItems[menuID].quantity = newQuantity;
                cartItems[menuID].total = cartItems[menuID].price * newQuantity;
                updateCart();
            });
        });

        var removeButtons = document.querySelectorAll('.remove-item');
        removeButtons.forEach(function(button) {
            button.addEventListener('click', function(e) {
                e.preventDefault();
                var menuID = e.currentTarget.getAttribute('data-id');
                delete cartItems[menuID];
                updateCart();
            });
        });
    }

    // Handle add to cart
    var addToCartButtons = document.querySelectorAll('.add-to-cart');
    addToCartButtons.forEach(function(button) {
        button.addEventListener('click', function(e) {
            e.preventDefault();

            // Check if the user is logged in
            if (userId === -1) {
                // User is not logged in, show the login modal
                var loginModal = new bootstrap.Modal(document.getElementById('loginModal'));
                loginModal.show();
                return; // Exit function if user is not logged in
            }

            var menuID = button.getAttribute('data-id');
            var menuName = button.getAttribute('data-name');
            var menuPrice = parseFloat(button.getAttribute('data-price'));

            if (!cartItems[menuID]) {
                cartItems[menuID] = {
                    name: menuName,
                    price: menuPrice,
                    quantity: 1,
                    total: menuPrice
                };
            } else {
                cartItems[menuID].quantity++;
                cartItems[menuID].total = cartItems[menuID].quantity * menuPrice;
            }
            updateCart();
        });
    });

    checkoutButton.addEventListener('click', function() {
        if (Object.keys(cartItems).length === 0) {
            alert("Your cart is empty!");
            return;
        }

        var foodNamewithQT = Object.values(cartItems).map(item => item.name + '(' + item.quantity + ')').join(', ');
        var totalPrice = Object.values(cartItems).reduce((sum, item) => sum + item.total, 0).toFixed(2);

        // Get the current date and time in local time zone
        var now = new Date();
        var datetime = now.getFullYear() + '-' +
                       String(now.getMonth() + 1).padStart(2, '0') + '-' +
                       String(now.getDate()).padStart(2, '0') + ' ' +
                       String(now.getHours()).padStart(2, '0') + ':' +
                       String(now.getMinutes()).padStart(2, '0') + ':' +
                       String(now.getSeconds()).padStart(2, '0');

        // Set hidden form fields
        document.getElementById('hidden-foodNamewithQT').value = foodNamewithQT;
        document.getElementById('hidden-totalPrice').value = totalPrice;
        document.getElementById('hidden-datetime').value = datetime;
        document.getElementById('hidden-userIdp').value = userId;

        // Populate the Thank You Modal with order details
        document.getElementById('order-summary').innerHTML = Object.values(cartItems).map(item => 
            '<p>' + item.name + ' (Quantity: ' + item.quantity + ') - Rs. ' + item.total.toFixed(2) + '</p>'
        ).join('');
        document.getElementById('thank-you-total').textContent = totalPrice;

        // Show the Thank You Modal
        var thankYouModal = new bootstrap.Modal(document.getElementById('thankYouModal'));
        thankYouModal.show();

        // Submit the order form after the modal is closed
        thankYouModal._element.addEventListener('hidden.bs.modal', function() {
            checkoutForm.submit();
        });
    });
 
 
    // Handle filtering
    const filterButtons = document.querySelectorAll('.filter-btn');
    const menuItems = document.querySelectorAll('.menu-item');

    filterButtons.forEach(button => {
        button.addEventListener('click', function() {
            const category = this.getAttribute('data-category');

            menuItems.forEach(item => {
                if (category === 'all' || item.getAttribute('data-category') === category) {
                    item.classList.remove('hidden'); // Show the item by removing the hidden class
                } else {
                    item.classList.add('hidden'); // Hide the item by adding the hidden class
                }
            });
        });
    });
});
</script>

<!-- /Menu Section -->
    
    
<!-- /Faciity Section -->
<section id="facilities" class="facilities section py-5"  style=" background-color: yellowgreen" >
    <!-- Section Title -->
			<div class="container section-title" data-aos="fade-up">
  				<hr style="width: 7%; height: 3px; background-color: #433f39; margin: 0 auto;">
 				<br>
  				<h1 style=" font-weight: 800;">OUR<span style=" color: white">FACILITIES</span></h1>
  				<p>Explore the unique facilities we offer to enhance your dining experience.</p>
        </div>
      <!-- End Section Title -->

   <div class="container">
    <div class="row">
        <c:forEach var="facility" items="${facility}">
            <div class="col-lg-4 col-md-6 mb-4">
                <div class="card h-100 shadow facility-card" data-aos="fade-up" data-aos-delay="100">
                    <img src="${facility.facilityImg}" class="card-img-top" alt="${facility.facilityName}">
                    <div class="card-body">
                        <h5 class="card-title">${facility.facilityName}</h5>
                        <p class="card-text">${facility.description}</p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</section>
<!-- /Facilities Section -->


<!-- Offer Section -->
<section id="events" class="events section">

  <img class="slider-bg" src="assets/img/people-enjoying-mexican-barbecue.jpg" alt="" data-aos="fade-in" Style="width: 100%">

  <div class="container">

    <div class="swiper init-swiper" data-aos="fade-up" data-aos-delay="100">
      <script type="application/json" class="swiper-config">
        {
          "loop": true,
          "speed": 600,
          "autoplay": {
            "delay": 5000
          },
          "slidesPerView": "auto",
          "pagination": {
            "el": ".swiper-pagination",
            "type": "bullets",
            "clickable": true
          }
        }
      </script>
     <div class="swiper-wrapper">
     <c:forEach var="offer" items="${offers}">
        <div class="swiper-slide">
            <div class="row gy-4 event-item">
                <div class="col-lg-6">
                    <img src="${offer.offerImg}" class="img-fluid" alt="${offer.title}">
                </div>
                <div class="col-lg-6 pt-4 pt-lg-0 content">
                    <h3>${offer.title}</h3>
                    <div class="price">
                        <p><span>Rs.${offer.price}</span></p>
                    </div>
                    <p class="fst-italic">
                        ${offer.description}
                    </p>
                </div>
            </div>
        </div><!-- End Slider item -->
     </c:forEach>
     </div>


      <div class="swiper-pagination"></div>
    </div>
  </div>
<script>
  document.addEventListener('DOMContentLoaded', function () {

    var swiper = new Swiper('.swiper', {
      loop: true,
      speed: 600,
      autoplay: {
        delay: 5000,
      },
      slidesPerView: 'auto',
      pagination: {
        el: '.swiper-pagination',
        type: 'bullets',
        clickable: true,
      },
    });
  });

  
 document.addEventListener('DOMContentLoaded', function () {
	    // Optional: Customize or initialize Bootstrap tabs if necessary
	  });
</script>  
</section>
<!-- End Offer Section -->

<!-- Book A Table Section -->
<section id="book-a-table" class="book-a-table section" style="background-color: #f7f7f7; padding: 50px 0;">
    <!-- Section Title -->
    <div class="container section-title" data-aos="fade-up" style="text-align: center;">
        <hr style="width: 7%; height: 3px; background-color: #433f39; margin: 0 auto;">
        <br>
        <h1 style="font-weight: 800; font-size: 2.5rem; color: #333;">BOOK A <span style="color: yellowgreen;">TABLE</span></h1>
        <p style="color: #666; font-size: 1.1rem; margin-top: 10px;">
             Find a cozy spot in our restaurant, perfect for any meal. Book a table and enjoy great food in a friendly setting.<br> 
    			Reserve your place now and have a wonderful dining experience.
        </p>
    </div><!-- End Section Title -->

    <div class="container" style="background-color: #fff; box-shadow: 0px 4px 20px rgba(0, 0, 0, 0.1); border-radius: 8px; overflow: hidden;">
        <div class="row g-0" data-aos="fade-up" data-aos-delay="100">
          <div class="col-lg-4 reservation-img" style="background-image: url('assets/img/open-book-with-natural-element.jpg'); background-size: cover; background-position: center;"></div>

            <div class="col-lg-8 d-flex align-items-center reservation-form-bg" data-aos="fade-up" data-aos-delay="200" style="padding: 40px;">
                <form action="reservations?action=new" method="post" id="bookTableForm" style="width: 100%;">
                    <!-- Hidden input to store the user ID -->
                    <input type="hidden" id="userId" name="userId" value="<%= session.getAttribute("userId") != null ? session.getAttribute("userId").toString() : "-1" %>">
                    <input type="hidden" name="source" value="mainPage">
                    <!-- Hidden input to set the status to "pending" -->
                    <input type="hidden" name="status" value="pending">

                    <div class="row gy-4">
                        <div class="col-lg-4 col-md-6">
                            <input type="date" name="date" class="form-control" id="date" placeholder="Date" required style="padding: 10px; font-size: 1rem; border-radius: 4px; border: 2px solid yellowgreen;">
                        </div>
                        <div class="col-lg-4 col-md-6">
                            <input type="time" class="form-control" name="time" id="time" placeholder="Time" required style="padding: 10px; font-size: 1rem; border-radius: 4px; border: 2px solid yellowgreen;">
                        </div>
                        <div class="col-lg-4 col-md-6">
                            <input type="number" class="form-control" name="numberOfPeople" id="numberOfPeople" placeholder="Number of Peoples" required style="padding: 10px; font-size: 1rem; border-radius: 4px;border: 2px solid yellowgreen;">
                        </div>
                    </div>

                    <div class="form-group mt-3">
                        <textarea class="form-control" name="message" rows="5" placeholder="Message" style="padding: 10px; font-size: 1rem; border-radius: 4px; border: 2px solid yellowgreen;"></textarea>
                    </div>

                    <div class="text-center mt-3">
                        <button type="submit" id="bookTableButton" style="background-color: yellowgreen; color: #fff; padding: 12px 30px; border: none; border-radius: 4px; font-size: 1.2rem; cursor: pointer; transition: background-color 0.3s;">
                            Book a Table
                        </button>
                    </div>
                    <%-- Display success message --%>
                    <% String successMessage = (String) request.getAttribute("successMessage"); %>
                    <% if (successMessage != null) { %>
                        <div class="alert alert-success" role="alert" style="margin-top: 20px; font-size: 1rem;">
                            <%= successMessage %>
                        </div>
                    <% } %>
                </form>
            </div><!-- End Reservation Form -->
        </div>
    </div>
    <script>
	document.addEventListener('DOMContentLoaded', function() {
    var bookTableButton = document.getElementById('bookTableButton');
    var userId = document.getElementById('userId').value;

    bookTableButton.addEventListener('click', function(e) {
        // Check if the user is logged in
        if (userId === "-1") {
            e.preventDefault(); // Prevent the form from submitting

            // Show the login modal
            var loginModal = new bootstrap.Modal(document.getElementById('loginModal'));
            loginModal.show();
        } else {
            // Allow form submission if the user is logged in
        }
    });
});
</script>
</section><!-- /Book A Table Section -->


<!-- Gallery Section -->
    <section id="gallery" class="gallery section" style="background-color: yellowgreen;">

      <!-- Section Title -->
      <div class="container section-title" data-aos="fade-up">
        <hr style="width: 7%; height: 3px; background-color: #ffffff; margin: 0 auto;">
        <br>
        <h1 style=" font-weight: 800;">GA<span style="color: white;">LLERY</span></span></h1>
        <p>Explore our gallery to see the highlights of our restaurant through captivating images.</p>
      </div><!-- End Section Title -->

      <div class="container-fluid" data-aos="fade-up" data-aos-delay="100">

        <div class="row g-0">
		<c:forEach var="gallery" items="${gallery}">
          <div class="col-lg-3 col-md-4">
            <div class="gallery-item">
                <img src="${gallery.galleryImg}" alt="" class="img-fluid" style="width: 600px; height: 200px;">
              </a>
            </div>
          </div><!-- End Gallery Item -->
		</c:forEach>     
        </div>

      </div>

    </section>
<!-- /Gallery Section -->
<br>
<br>
<!-- Contact Section -->
<section id="contact" class="contact section" style="padding: 60px 0; background-color: #f9f9f9;">

  <!-- Section Title -->
  <div class="container section-title" data-aos="fade-up" style="text-align: center;">
    <hr style="width: 7%; height: 3px; background-color: #ffffff; margin: 0 auto;">
    <br>
    <h1 style="font-weight: 800; color: #333;">
      CONTACT<span style="color: yellowgreen;"> US</span>
    </h1>
    <p style="color: #666; font-size: 1.1rem;">
      Connect with us at ABC Restaurant. For reservations, inquiries, or feedback, we are here to make every interaction delightful. Reach out to enhance your dining experience with our exceptional service and personalized attention.
    </p>
  </div><!-- End Section Title -->

  <div class="container" data-aos="fade">
    <div class="row gy-5 gx-lg-5">

      <div class="col-lg-4">
        <div class="info" style="background: #fff; padding: 20px; border-radius: 8px; box-shadow: 0 4px 8px rgba(0,0,0,0.1);">
          <h3 style="font-size: 1.5rem; color: #333;">Get in touch</h3>
          <p style="color: #666; font-size: 1.1rem;">Reach out to us for reservations, inquiries, or feedback. We're here to help!</p>

          <div class="info-item d-flex" style="margin-bottom: 15px;">
            <i class="bi bi-geo-alt flex-shrink-0" style="font-size: 1.5rem; color: yellowgreen; margin-right: 10px;"></i>
            <div>
              <h4 style="margin-bottom: 5px; color: #333;">Location:</h4>
              <p style="color: #666;">Maithripala Senanayake Mawatha<br>Anuradhapura</p>
            </div>
          </div><!-- End Info Item -->

          <div class="info-item d-flex" style="margin-bottom: 15px;">
            <i class="bi bi-envelope flex-shrink-0" style="font-size: 1.5rem; color: yellowgreen; margin-right: 10px;"></i>
            <div>
              <h4 style="margin-bottom: 5px; color: #333;">Email:</h4>
              <p style="color: #666;">abcrestaurant22@gmail.com</p>
            </div>
          </div><!-- End Info Item -->

          <div class="info-item d-flex" style="margin-bottom: 15px;">
            <i class="bi bi-phone flex-shrink-0" style="font-size: 1.5rem; color: yellowgreen; margin-right: 10px;"></i>
            <div>
              <h4 style="margin-bottom: 5px; color: #333;">Call:</h4>
              <p style="color: #666;">0772910692</p>
            </div>
          </div><!-- End Info Item -->

        </div>
  	 </div>

      <div class="col-lg-8">
        <form action="contact" method="post" role="form" class="p-4" style="background: #fff; border-radius: 8px; box-shadow: 0 4px 8px rgba(0,0,0,0.1);">
          <div class="row">
            <div class="col-md-6 form-group">
              <input type="text" name="name" class="form-control" id="name" placeholder="Your Name" required style="border: 1px solid #ddd; border-radius: 4px;">
            </div>
            <div class="col-md-6 form-group mt-3 mt-md-0">
              <input type="email" class="form-control" name="email" id="email" placeholder="Your Email" required style="border: 1px solid #ddd; border-radius: 4px;">
            </div>
          </div>
          <div class="form-group mt-3">
            <input type="text" class="form-control" name="subject" id="subject" placeholder="Subject" required style="border: 1px solid #ddd; border-radius: 4px;">
          </div>
          <div class="form-group mt-3">
            <textarea class="form-control" name="message" placeholder="Message" required style="border: 1px solid #ddd; border-radius: 4px;"></textarea>
          </div>
          <div class="text-center mt-4">
            <button type="submit" style="background-color: yellowgreen; border: none; color: white; padding: 10px 20px; border-radius: 4px; font-size: 1rem;">Send Message</button>
          </div>
        </form>
      </div><!-- End Contact Form -->

    </div>
  </div>
</section>
<!-- /Contact Section -->
  </main>

 <footer id="footer" class="footer bg-dark text-white py-5">
  <div class="container">
    <div class="row">
      <!-- Address Section -->
      <div class="col-lg-3 col-md-6 mb-4 mb-md-0">
        <h4 class="text-uppercase mb-3">Address</h4>
        <p><i class="bi bi-geo-alt me-2"></i>Maithripala Senanayake Mawatha</p>
        <p>Anuradhapura</p>
      </div>

      <!-- Contact Section -->
      <div class="col-lg-3 col-md-6 mb-4 mb-md-0">
        <h4 class="text-uppercase mb-3">Contact</h4>
        <p><i class="bi bi-telephone me-2"></i><strong>Phone:</strong> 0772910692</p>
        <p><i class="bi bi-envelope me-2"></i><strong>Email:</strong> abcrestaurant22@gmail.com</p>
      </div>

      <!-- Opening Hours Section -->
      <div class="col-lg-3 col-md-6 mb-4 mb-md-0">
        <h4 class="text-uppercase mb-3">Opening Hours</h4>
        <p><i class="bi bi-clock me-2"></i><strong>Mon-Sat:</strong> 9AM - 11PM</p>
        <p><strong>Sunday:</strong> Closed</p>
      </div>

      <!-- Follow Us Section -->
      <div class="col-lg-3 col-md-6 mb-4 mb-md-0">
        <h4 class="text-uppercase mb-3">Follow Us</h4>
        <div class="d-flex">
          <a href="#" class="me-3 text-white"><i class="bi bi-twitter"></i></a>
          <a href="#" class="me-3 text-white"><i class="bi bi-facebook"></i></a>
          <a href="#" class="me-3 text-white"><i class="bi bi-instagram"></i></a>
          <a href="#" class="text-white"><i class="bi bi-linkedin"></i></a>
        </div>
      </div>
    </div>
  </div>

  <div class="container mt-4 text-center">
    <p class="mb-0">&copy; <span>Copyright</span> <strong class="px-1">ABC Restaurant</strong> <span>All Rights Reserved</span></p>
    <p class="mb-0">Designed by <a href="https://www.linkedin.com/in/pethum-srilal-a7417a2b1" class="text-white">Pethum Shyam</a></p>
  </div>
</footer>

 




<!--Modals -->
<!-- Login Modal -->
<div class="modal fade" id="loginModal" tabindex="-1" aria-labelledby="loginModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content" style="border-radius: 20px; overflow: hidden;">
            <!-- Modal Header -->
            <div class="modal-header" style="background-color: yellowgreen; color: whitesmoke;">
                <h5 class="modal-title" id="loginModalLabel" style="font-weight: bold;">Please log in</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close" style="color: whitesmoke;"></button>
            </div>
            <!-- Modal Body -->
            <div class="modal-body p-4" style="background-color: #f9f9f9;">
                <form action="customer-login" method="post">
                    <!-- Username Field -->
                    <div class="form-group mb-3">
                        <label for="username" style="font-weight: bold; color: #333;">Username</label>
                        <input type="text" class="form-control" id="username" name="username" placeholder="Enter your username" required 
                               style="border-radius: 5px; border: 1px solid #ccc; padding: 10px; font-size: 1rem;">
                    </div>
                    <!-- Password Field -->
                    <div class="form-group mb-4">
                        <label for="password" style="font-weight: bold; color: #333;">Password</label>
                        <input type="password" class="form-control" id="password" name="password" placeholder="Enter your password" required 
                               style="border-radius: 5px; border: 1px solid #ccc; padding: 10px; font-size: 1rem;">
                    </div>
                    <!-- Submit Button -->
                    <button type="submit" class="btn btn-block" 
                            style="background-color: yellowgreen; color: whitesmoke; border: none; border-radius: 30px; padding: 10px; font-size: 1.1rem; font-weight: bold;">
                        Login
                    </button>
                </form>

                <!-- Error Message -->
                <% String errorMessage = (String) request.getAttribute("errorMessage"); %>
                <% if (errorMessage != null) { %>
                    <div class="alert alert-danger mt-3 text-center" role="alert" style="margin: 0; border-radius: 0;">
                        <%= errorMessage %>
                    </div>
                    <script>
                        // Reopen the login modal if there was an error
                        var myModal = new bootstrap.Modal(document.getElementById('loginModal'), {});
                        myModal.show();
                    </script>
                <% } %>
                
                <!-- Sign-up Prompt -->
                <div class="mt-4 text-center">
                  <p style="font-size: 0.9rem; color: #666;">
                   Haven't an account? 
    			  <a href="#" style="color: yellowgreen; font-weight: bold;" data-bs-toggle="modal" data-bs-target="#registerModal">
       			  Please sign up
                  </a>
				</p>
                </div>
            </div>
        </div>
    </div>
</div>


<!-- Customer Registration Modal -->
<div class="modal fade" id="registerModal" tabindex="-1" aria-labelledby="registerModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content" style="border-radius: 20px; overflow: hidden;">
            <!-- Modal Header -->
            <div class="modal-header" style="background-color: yellowgreen; color: whitesmoke;">
                <h5 class="modal-title" id="registerModalLabel" style="font-weight: bold;">Register</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close" style="color: whitesmoke;"></button>
            </div>
            <!-- Modal Body -->
            <div class="modal-body p-4" style="background-color: #f9f9f9;">
            
                <form action="user" method="post">
                    <input type="hidden" name="action" value="add"/>

                    <!-- Username Field -->
                    <div class="form-group mb-3">
                        <label for="username" style="font-weight: bold; color: #333;">Username</label>
                        <input type="text" class="form-control" id="username" name="username" placeholder="Enter your username" required 
                               style="border-radius: 5px; border: 1px solid #ccc; padding: 10px; font-size: 1rem;">
                    </div>

                    <!-- Password Field -->
                    <div class="form-group mb-3">
                        <label for="password" style="font-weight: bold; color: #333;">Password</label>
                        <input type="password" class="form-control" id="password" name="password" placeholder="Enter your password" required 
                               style="border-radius: 5px; border: 1px solid #ccc; padding: 10px; font-size: 1rem;">
                    </div>

                    <!-- Email Field -->
                    <div class="form-group mb-3">
                        <label for="email" style="font-weight: bold; color: #333;">Email</label>
                        <input type="email" class="form-control" id="email" name="email" placeholder="Enter your email" required 
                               style="border-radius: 5px; border: 1px solid #ccc; padding: 10px; font-size: 1rem;">
                    </div>

                    <!-- Phone Field -->
                    <div class="form-group mb-3">
                        <label for="phone" style="font-weight: bold; color: #333;">Phone</label>
                      <input type="tel" class="form-control" id="phone" name="phone" placeholder="Enter your phone number" require pattern="\d{10}" maxlength="10" title="Please enter exactly 10 digits" style="border-radius: 5px; border: 1px solid #ccc; padding: 10px; font-size: 1rem;">

                    </div>
					
					<% String registrationErrorMessage = (String) request.getAttribute("errorMessage"); %>
					<% if (registrationErrorMessage != null) { %>
    				<div class="alert alert-danger"><%= registrationErrorMessage %></div>
						<% } %>
						
                    <!-- Hidden Role Field -->
                    <input type="hidden" name="role" value="Customer"/>

                    <!-- Submit Button -->
                    <button type="submit" class="btn btn-block" 
                            style="background-color: yellowgreen; color: whitesmoke; border: none; border-radius: 30px; padding: 10px; font-size: 1.1rem; font-weight: bold;">
                        Register
                    </button>
                    
                </form>
            </div>
        </div>
    </div>
</div>
<!-- Thank You Modal -->
<div class="modal fade" id="thankYouModal" tabindex="-1" aria-labelledby="thankYouModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" style="max-width: 300px; margin: auto;">
        <div class="modal-content" style="border: none; border-radius: 12px; background-color: #fff; color: #333;">
            <div class="modal-header" style="border-bottom: 1px solid #e0e0e0; background-color: #f7f7f7;">
                <h5 class="modal-title" id="thankYouModalLabel" style="color: #9ACD32; font-weight: bold; font-size: 1.25rem;">Thank You for Your Order!</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body" style="text-align: center;">
                <p>Your order has been successfully placed. Here are the details:</p>
                <div id="order-summary" style="margin-bottom: 1rem;">
                    <!-- Order summary will be dynamically loaded here -->
                </div>
                <h5 class="mt-3" style="color: #333;">Total: Rs. <span id="thank-you-total" style="color: #9ACD32;">0.00</span></h5>
            </div>
            <div class="modal-footer" style="border-top: none; justify-content: center;">
                <button type="button" class="btn btn-primary" data-bs-dismiss="modal" style="background-color: #9ACD32; border-color: #9ACD32;">Close</button>
            </div>
        </div>
    </div>
</div>





  <!-- Scroll Top -->
  <a href="#" id="scroll-top" class="scroll-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

  <!-- Preloader -->
  <div id="preloader"></div>

  <!-- Vendor JS Files -->
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets/vendor/php-email-form/validate.js"></script>
  <script src="assets/vendor/aos/aos.js"></script>
 
  <script src="assets/vendor/imagesloaded/imagesloaded.pkgd.min.js"></script>
  <script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
  <script src="assets/vendor/swiper/swiper-bundle.min.js"></script>

<!-- Main JS File -->
  <script src="assets/js/main.js"></script>

</body>




</html>