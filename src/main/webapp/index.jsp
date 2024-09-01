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
<% // Retrieve user ID from session
Integer userId = (Integer) session.getAttribute("userId");%>

<%
    // Retrieve the username from the session
    String username = (String) session.getAttribute("username");

%>

	<script>
    	// Make the user ID available to JavaScript
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
            <li><a href="#specials">Specials</a></li>
            <li><a href="#events">Facilities</a></li>
            <li><a href="#chefs">Chefs</a></li>
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
<!-- About Section -->
<section id="about" class="about section light-background">

      <div class="container">
<!-- Section Title -->
			<div class="container section-title" data-aos="fade-up">
  				<hr style="width: 7%; height: 3px; background-color: #433f39; margin: 0 auto;">
 				<br>
  				<h1 style=" font-weight: 800;">ABOUT <span style=" color: yellowgreen">US</span></h1>
  				<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia,there live the blind texts.<br> Separated they live in Bookmarksgrove right at the coast   
	            of the Semantics,<br> a large language ocean.</p>
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

    </section><!-- /About Section -->

    <br>
    <br>
    <!-- Why Us Section -->
    <section id="why-us" class="why-us section" style=" background-color: yellowgreen;">

     <!-- Section Title -->
    <div class="container section-title" data-aos="fade-up">
  	<hr style="width: 7%; height: 3px; background-color: #ffffff; margin: 0 auto;">
  	<br>
  	<h1 style=" font-weight: 800;">OUR <span style="color: white;">SERVICES</span></span></h1>
  	<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia,there live the blind texts.<br> Separated they live in Bookmarksgrove right at the coast   
 	of the Semantics,<br> a large language ocean.</p>
	</div><!-- End Section Title -->
	
	
    <div class="container">

        <div class="row gy-4">

          <div class="col-lg-4" data-aos="fade-up" data-aos-delay="100">
            <div class="card-item">
              <span>01</span>
              <h4><a href="" class="stretched-link">Lorem Ipsum</a></h4>
              <p>Ulamco laboris nisi ut aliquip ex ea commodo consequat. Et consectetur ducimus vero placeat</p>
            </div>
          </div><!-- Card Item -->

          <div class="col-lg-4" data-aos="fade-up" data-aos-delay="200">
            <div class="card-item">
              <span>02</span>
              <h4><a href="" class="stretched-link">Repellat Nihil</a></h4>
              <p>Dolorem est fugiat occaecati voluptate velit esse. Dicta veritatis dolor quod et vel dire leno para dest</p>
            </div>
          </div><!-- Card Item -->

          <div class="col-lg-4" data-aos="fade-up" data-aos-delay="300">
            <div class="card-item">
              <span>03</span>
              <h4><a href="" class="stretched-link">Ad ad velit qui</a></h4>
              <p>Molestiae officiis omnis illo asperiores. Aut doloribus vitae sunt debitis quo vel nam quis</p>
            </div>
          </div><!-- Card Item -->

        </div>

      </div>

    </section><!-- /Why Us Section -->
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
  </div><!-- End Section Title -->

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
            <div class="col-md-3 mb-4 menu-item" data-category="${menu.category}">
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
        </div><!-- End Row -->
      </div><!-- End Container -->
    </section><!-- End Menu Filter Section -->

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

 // Handle checkout
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

        document.getElementById('hidden-foodNamewithQT').value = foodNamewithQT;
        document.getElementById('hidden-totalPrice').value = totalPrice;
        document.getElementById('hidden-datetime').value = datetime;

        // Set the userIdp value
        document.getElementById('hidden-userIdp').value = userId;

        checkoutForm.submit();
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
    <!-- Specials Section -->
    <section id="specials" class="specials section">

      <!-- Section Title -->
      <div class="container section-title" data-aos="fade-up">
        <h2>Specials</h2>
        <div><span>Check Our</span> <span class="description-title">Specials</span></div>
      </div><!-- End Section Title -->

      <div class="container" data-aos="fade-up" data-aos-delay="100">

        <div class="row">
          <div class="col-lg-3">
            <ul class="nav nav-tabs flex-column">
              <li class="nav-item">
                <a class="nav-link active show" data-bs-toggle="tab" href="#specials-tab-1">Modi sit est</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" data-bs-toggle="tab" href="#specials-tab-2">Unde praesentium sed</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" data-bs-toggle="tab" href="#specials-tab-3">Pariatur explicabo vel</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" data-bs-toggle="tab" href="#specials-tab-4">Nostrum qui quasi</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" data-bs-toggle="tab" href="#specials-tab-5">Iusto ut expedita aut</a>
              </li>
            </ul>
          </div>
          <div class="col-lg-9 mt-4 mt-lg-0">
            <div class="tab-content">
              <div class="tab-pane active show" id="specials-tab-1">
                <div class="row">
                  <div class="col-lg-8 details order-2 order-lg-1">
                    <h3>Architecto ut aperiam autem id</h3>
                    <p class="fst-italic">Qui laudantium consequatur laborum sit qui ad sapiente dila parde sonata raqer a videna mareta paulona marka</p>
                    <p>Et nobis maiores eius. Voluptatibus ut enim blanditiis atque harum sint. Laborum eos ipsum ipsa odit magni. Incidunt hic ut molestiae aut qui. Est repellat minima eveniet eius et quis magni nihil. Consequatur dolorem quaerat quos qui similique accusamus nostrum rem vero</p>
                  </div>
                  <div class="col-lg-4 text-center order-1 order-lg-2">
                    <img src="assets/img/specials-1.jpg" alt="" class="img-fluid">
                  </div>
                </div>
              </div>
              <div class="tab-pane" id="specials-tab-2">
                <div class="row">
                  <div class="col-lg-8 details order-2 order-lg-1">
                    <h3>Et blanditiis nemo veritatis excepturi</h3>
                    <p class="fst-italic">Qui laudantium consequatur laborum sit qui ad sapiente dila parde sonata raqer a videna mareta paulona marka</p>
                    <p>Ea ipsum voluptatem consequatur quis est. Illum error ullam omnis quia et reiciendis sunt sunt est. Non aliquid repellendus itaque accusamus eius et velit ipsa voluptates. Optio nesciunt eaque beatae accusamus lerode pakto madirna desera vafle de nideran pal</p>
                  </div>
                  <div class="col-lg-4 text-center order-1 order-lg-2">
                    <img src="assets/img/specials-2.jpg" alt="" class="img-fluid">
                  </div>
                </div>
              </div>
              <div class="tab-pane" id="specials-tab-3">
                <div class="row">
                  <div class="col-lg-8 details order-2 order-lg-1">
                    <h3>Impedit facilis occaecati odio neque aperiam sit</h3>
                    <p class="fst-italic">Eos voluptatibus quo. Odio similique illum id quidem non enim fuga. Qui natus non sunt dicta dolor et. In asperiores velit quaerat perferendis aut</p>
                    <p>Iure officiis odit rerum. Harum sequi eum illum corrupti culpa veritatis quisquam. Neque necessitatibus illo rerum eum ut. Commodi ipsam minima molestiae sed laboriosam a iste odio. Earum odit nesciunt fugiat sit ullam. Soluta et harum voluptatem optio quae</p>
                  </div>
                  <div class="col-lg-4 text-center order-1 order-lg-2">
                    <img src="assets/img/specials-3.jpg" alt="" class="img-fluid">
                  </div>
                </div>
              </div>
              <div class="tab-pane" id="specials-tab-4">
                <div class="row">
                  <div class="col-lg-8 details order-2 order-lg-1">
                    <h3>Fuga dolores inventore laboriosam ut est accusamus laboriosam dolore</h3>
                    <p class="fst-italic">Totam aperiam accusamus. Repellat consequuntur iure voluptas iure porro quis delectus</p>
                    <p>Eaque consequuntur consequuntur libero expedita in voluptas. Nostrum ipsam necessitatibus aliquam fugiat debitis quis velit. Eum ex maxime error in consequatur corporis atque. Eligendi asperiores sed qui veritatis aperiam quia a laborum inventore</p>
                  </div>
                  <div class="col-lg-4 text-center order-1 order-lg-2">
                    <img src="assets/img/specials-4.jpg" alt="" class="img-fluid">
                  </div>
                </div>
              </div>
              <div class="tab-pane" id="specials-tab-5">
                <div class="row">
                  <div class="col-lg-8 details order-2 order-lg-1">
                    <h3>Est eveniet ipsam sindera pad rone matrelat sando reda</h3>
                    <p class="fst-italic">Omnis blanditiis saepe eos autem qui sunt debitis porro quia.</p>
                    <p>Exercitationem nostrum omnis. Ut reiciendis repudiandae minus. Omnis recusandae ut non quam ut quod eius qui. Ipsum quia odit vero atque qui quibusdam amet. Occaecati sed est sint aut vitae molestiae voluptate vel</p>
                  </div>
                  <div class="col-lg-4 text-center order-1 order-lg-2">
                    <img src="assets/img/specials-5.jpg" alt="" class="img-fluid">
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>

      </div>

    </section><!-- /Specials Section -->
	
	
<script>

</script>

	


    <!-- Events Section -->
<section id="events" class="events section">

  <img class="slider-bg" src="assets/img/events-bg.jpg" alt="" data-aos="fade-in">

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
                        <p><span>${offer.price}</span></p>
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
</section><!-- End Events Section -->



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

    <!-- Book A Table Section -->
    <section id="book-a-table" class="book-a-table section">

      <!-- Section Title -->
      <div class="container section-title" data-aos="fade-up">
        <hr style="width: 7%; height: 3px; background-color: #433f39; margin: 0 auto;">
        <br>
        <h1 style=" font-weight: 800;">BOOK A <span style=" color: yellowgreen">TABLE</span></h1>
        <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia,there live the blind texts.<br> Separated they live in Bookmarksgrove right at the coast   
          of the Semantics,<br> a large language ocean.</p>
      </div><!-- End Section Title -->

      <div class="container">

        <div class="row g-0" data-aos="fade-up" data-aos-delay="100">

          <div class="col-lg-4 reservation-img" style="background-image: url(assets/img/reservation.jpg);"></div>

          <div class="col-lg-8 d-flex align-items-center reservation-form-bg" data-aos="fade-up" data-aos-delay="200">
            <form action="forms/book-a-table.php" method="post" role="form" class="php-email-form">
              <div class="row gy-4">
                <div class="col-lg-4 col-md-6">
                  <input type="text" name="name" class="form-control" id="name" placeholder="Your Name" required="">
                </div>
                <div class="col-lg-4 col-md-6">
                  <input type="email" class="form-control" name="email" id="email" placeholder="Your Email" required="">
                </div>
                <div class="col-lg-4 col-md-6">
                  <input type="text" class="form-control" name="phone" id="phone" placeholder="Your Phone" required="">
                </div>
                <div class="col-lg-4 col-md-6">
                  <input type="date" name="date" class="form-control" id="date" placeholder="Date" required="">
                </div>
                <div class="col-lg-4 col-md-6">
                  <input type="time" class="form-control" name="time" id="time" placeholder="Time" required="">
                </div>
                <div class="col-lg-4 col-md-6">
                  <input type="number" class="form-control" name="people" id="people" placeholder="# of people" required="">
                </div>
              </div>

              <div class="form-group mt-3">
                <textarea class="form-control" name="message" rows="5" placeholder="Message"></textarea>
              </div>

              <div class="text-center mt-3">
                <div class="loading">Loading</div>
                <div class="error-message"></div>
                <div class="sent-message">Your booking request was sent. We will call back or send an Email to confirm your reservation. Thank you!</div>
                <button type="submit">Book a Table</button>
              </div>
            </form>
          </div><!-- End Reservation Form -->

        </div>

      </div>

    </section><!-- /Book A Table Section -->

    <!-- Gallery Section -->
    <section id="gallery" class="gallery section" style="background-color: yellowgreen;">

      <!-- Section Title -->
      <div class="container section-title" data-aos="fade-up">
        <hr style="width: 7%; height: 3px; background-color: #ffffff; margin: 0 auto;">
        <br>
        <h1 style=" font-weight: 800;">GA<span style="color: white;">LLERY</span></span></h1>
        <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia,there live the blind texts.<br> Separated they live in Bookmarksgrove right at the coast   
       of the Semantics,<br> a large language ocean.</p>
      </div><!-- End Section Title -->

      <div class="container-fluid" data-aos="fade-up" data-aos-delay="100">

        <div class="row g-0">

          <div class="col-lg-3 col-md-4">
            <div class="gallery-item">
              <a href="assets/img/gallery/gallery-1.jpg" class="glightbox" data-gallery="images-gallery">
                <img src="assets/img/gallery/gallery-1.jpg" alt="" class="img-fluid">
              </a>
            </div>
          </div><!-- End Gallery Item -->

          <div class="col-lg-3 col-md-4">
            <div class="gallery-item">
              <a href="assets/img/gallery/gallery-2.jpg" class="glightbox" data-gallery="images-gallery">
                <img src="assets/img/gallery/gallery-2.jpg" alt="" class="img-fluid">
              </a>
            </div>
          </div><!-- End Gallery Item -->

          <div class="col-lg-3 col-md-4">
            <div class="gallery-item">
              <a href="assets/img/gallery/gallery-3.jpg" class="glightbox" data-gallery="images-gallery">
                <img src="assets/img/gallery/gallery-3.jpg" alt="" class="img-fluid">
              </a>
            </div>
          </div><!-- End Gallery Item -->

          <div class="col-lg-3 col-md-4">
            <div class="gallery-item">
              <a href="assets/img/gallery/gallery-4.jpg" class="glightbox" data-gallery="images-gallery">
                <img src="assets/img/gallery/gallery-4.jpg" alt="" class="img-fluid">
              </a>
            </div>
          </div><!-- End Gallery Item -->

          <div class="col-lg-3 col-md-4">
            <div class="gallery-item">
              <a href="assets/img/gallery/gallery-5.jpg" class="glightbox" data-gallery="images-gallery">
                <img src="assets/img/gallery/gallery-5.jpg" alt="" class="img-fluid">
              </a>
            </div>
          </div><!-- End Gallery Item -->

          <div class="col-lg-3 col-md-4">
            <div class="gallery-item">
              <a href="assets/img/gallery/gallery-6.jpg" class="glightbox" data-gallery="images-gallery">
                <img src="assets/img/gallery/gallery-6.jpg" alt="" class="img-fluid">
              </a>
            </div>
          </div><!-- End Gallery Item -->

          <div class="col-lg-3 col-md-4">
            <div class="gallery-item">
              <a href="assets/img/gallery/gallery-7.jpg" class="glightbox" data-gallery="images-gallery">
                <img src="assets/img/gallery/gallery-7.jpg" alt="" class="img-fluid">
              </a>
            </div>
          </div><!-- End Gallery Item -->

          <div class="col-lg-3 col-md-4">
            <div class="gallery-item">
              <a href="assets/img/gallery/gallery-8.jpg" class="glightbox" data-gallery="images-gallery">
                <img src="assets/img/gallery/gallery-8.jpg" alt="" class="img-fluid">
              </a>
            </div>
          </div><!-- End Gallery Item -->

        </div>

      </div>

    </section><!-- /Gallery Section -->
<br>
<br>
    <!-- Testimonials Section -->
    <section id="testimonials" class="testimonials section dark-background">

      <img src="assets/img/testimonials-bg.jpg" class="testimonials-bg" alt="">

      <div class="container" data-aos="fade-up" data-aos-delay="100">

        <div class="swiper init-swiper">
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

            <div class="swiper-slide">
              <div class="testimonial-item">
                <img src="assets/img/testimonials/testimonials-1.jpg" class="testimonial-img" alt="">
                <h3>Saul Goodman</h3>
                <h4>Ceo &amp; Founder</h4>
                <div class="stars">
                  <i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i>
                </div>
                <p>
                  <i class="bi bi-quote quote-icon-left"></i>
                  <span>Proin iaculis purus consequat sem cure digni ssim donec porttitora entum suscipit rhoncus. Accusantium quam, ultricies eget id, aliquam eget nibh et. Maecen aliquam, risus at semper.</span>
                  <i class="bi bi-quote quote-icon-right"></i>
                </p>
              </div>
            </div><!-- End testimonial item -->

            <div class="swiper-slide">
              <div class="testimonial-item">
                <img src="assets/img/testimonials/testimonials-2.jpg" class="testimonial-img" alt="">
                <h3>Sara Wilsson</h3>
                <h4>Designer</h4>
                <div class="stars">
                  <i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i>
                </div>
                <p>
                  <i class="bi bi-quote quote-icon-left"></i>
                  <span>Export tempor illum tamen malis malis eram quae irure esse labore quem cillum quid cillum eram malis quorum velit fore eram velit sunt aliqua noster fugiat irure amet legam anim culpa.</span>
                  <i class="bi bi-quote quote-icon-right"></i>
                </p>
              </div>
            </div><!-- End testimonial item -->

            <div class="swiper-slide">
              <div class="testimonial-item">
                <img src="assets/img/testimonials/testimonials-3.jpg" class="testimonial-img" alt="">
                <h3>Jena Karlis</h3>
                <h4>Store Owner</h4>
                <div class="stars">
                  <i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i>
                </div>
                <p>
                  <i class="bi bi-quote quote-icon-left"></i>
                  <span>Enim nisi quem export duis labore cillum quae magna enim sint quorum nulla quem veniam duis minim tempor labore quem eram duis noster aute amet eram fore quis sint minim.</span>
                  <i class="bi bi-quote quote-icon-right"></i>
                </p>
              </div>
            </div><!-- End testimonial item -->

            <div class="swiper-slide">
              <div class="testimonial-item">
                <img src="assets/img/testimonials/testimonials-4.jpg" class="testimonial-img" alt="">
                <h3>Matt Brandon</h3>
                <h4>Freelancer</h4>
                <div class="stars">
                  <i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i>
                </div>
                <p>
                  <i class="bi bi-quote quote-icon-left"></i>
                  <span>Fugiat enim eram quae cillum dolore dolor amet nulla culpa multos export minim fugiat minim velit minim dolor enim duis veniam ipsum anim magna sunt elit fore quem dolore labore illum veniam.</span>
                  <i class="bi bi-quote quote-icon-right"></i>
                </p>
              </div>
            </div><!-- End testimonial item -->

            <div class="swiper-slide">
              <div class="testimonial-item">
                <img src="assets/img/testimonials/testimonials-5.jpg" class="testimonial-img" alt="">
                <h3>John Larson</h3>
                <h4>Entrepreneur</h4>
                <div class="stars">
                  <i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i>
                </div>
                <p>
                  <i class="bi bi-quote quote-icon-left"></i>
                  <span>Quis quorum aliqua sint quem legam fore sunt eram irure aliqua veniam tempor noster veniam enim culpa labore duis sunt culpa nulla illum cillum fugiat legam esse veniam culpa fore nisi cillum quid.</span>
                  <i class="bi bi-quote quote-icon-right"></i>
                </p>
              </div>
            </div><!-- End testimonial item -->

          </div>
          <div class="swiper-pagination"></div>
        </div>

      </div>

    </section><!-- /Testimonials Section -->

    <!-- Contact Section -->
    <section id="contact" class="contact section">

       <!-- Section Title -->
       <div class="container section-title" data-aos="fade-up">
        <hr style="width: 7%; height: 3px; background-color: #ffffff; margin: 0 auto;">
        <br>
        <h1 style=" font-weight: 800;">CONTACT<span style="color: yellowgreen;">US</span></span></h1>
        <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia,there live the blind texts.<br> Separated they live in Bookmarksgrove right at the coast   
       of the Semantics,<br> a large language ocean.</p>
      </div><!-- End Section Title -->
      
      <div class="container" data-aos="fade">

        <div class="row gy-5 gx-lg-5">

          <div class="col-lg-4">

            <div class="info">
              <h3>Get in touch</h3>
              <p>Et id eius voluptates atque nihil voluptatem enim in tempore minima sit ad mollitia commodi minus.</p>

              <div class="info-item d-flex">
                <i class="bi bi-geo-alt flex-shrink-0"></i>
                <div>
                  <h4>Location:</h4>
                  <p>A108 Adam Street, New York, NY 535022</p>
                </div>
              </div><!-- End Info Item -->

              <div class="info-item d-flex">
                <i class="bi bi-envelope flex-shrink-0"></i>
                <div>
                  <h4>Email:</h4>
                  <p>info@example.com</p>
                </div>
              </div><!-- End Info Item -->

              <div class="info-item d-flex">
                <i class="bi bi-phone flex-shrink-0"></i>
                <div>
                  <h4>Call:</h4>
                  <p>+1 5589 55488 55</p>
                </div>
              </div><!-- End Info Item -->

            </div>

          </div>

          <div class="col-lg-8">
            <form action="" method="post" role="form" class="p">
              <div class="row">
                <div class="col-md-6 form-group">
                  <input type="text" name="name" class="form-control" id="name" placeholder="Your Name" required="">
                </div>
                <div class="col-md-6 form-group mt-3 mt-md-0">
                  <input type="email" class="form-control" name="email" id="email" placeholder="Your Email" required="">
                </div>
              </div>
              <div class="form-group mt-3">
                <input type="text" class="form-control" name="subject" id="subject" placeholder="Subject" required="">
              </div>
              <div class="form-group mt-3">
                <textarea class="form-control" name="message" placeholder="Message" required=""></textarea>
              </div>
              <div class="my-3">
                <div class="loading">Loading</div>
                <div class="error-message"></div>
                <div class="sent-message">Your message has been sent. Thank you!</div>
              </div>
              <div class="text-center"><button type="submit">Send Message</button></div>
            </form>
          </div><!-- End Contact Form -->

        </div>

      </div>

    </section><!-- /Contact Section -->

  </main>

  <footer id="footer" class="footer dark-background">

    <div class="container">
      <div class="row gy-3">
        <div class="col-lg-3 col-md-6 d-flex">
          <i class="bi bi-geo-alt icon"></i>
          <div class="address">
            <h4>Address</h4>
            <p>A108 Adam Street</p>
            <p>New York, NY 535022</p>
            <p></p>
          </div>

        </div>

        <div class="col-lg-3 col-md-6 d-flex">
          <i class="bi bi-telephone icon"></i>
          <div>
            <h4>Contact</h4>
            <p>
              <strong>Phone:</strong> <span>+1 5589 55488 55</span><br>
              <strong>Email:</strong> <span>info@example.com</span><br>
            </p>
          </div>
        </div>

        <div class="col-lg-3 col-md-6 d-flex">
          <i class="bi bi-clock icon"></i>
          <div>
            <h4>Opening Hours</h4>
            <p>
              <strong>Mon-Sat:</strong> <span>11AM - 23PM</span><br>
              <strong>Sunday</strong>: <span>Closed</span>
            </p>
          </div>
        </div>

        <div class="col-lg-3 col-md-6">
          <h4>Follow Us</h4>
          <div class="social-links d-flex">
            <a href="#" class="twitter"><i class="bi bi-twitter-x"></i></a>
            <a href="#" class="facebook"><i class="bi bi-facebook"></i></a>
            <a href="#" class="instagram"><i class="bi bi-instagram"></i></a>
            <a href="#" class="linkedin"><i class="bi bi-linkedin"></i></a>
          </div>
        </div>

      </div>
    </div>

    <div class="container copyright text-center mt-4">
      <p>© <span>Copyright</span> <strong class="px-1 sitename">ABC Restaurant</strong> <span>All Rights Reserved</span></p>
      <div class="credits">
        Designed by <a href="www.linkedin.com/in/pethum-srilal-a7417a2b1">Pethum Shyam</a>
      </div>
    </div>

  </footer>

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
                <form action="login" method="post">
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
                <!-- Sign-up Prompt -->
                <div class="mt-4 text-center">
                    <p style="font-size: 0.9rem; color: #666;">Haven't an account? <a href="#" style="color: yellowgreen; font-weight: bold;">Please sign up</a></p>
                </div>
            </div>
            <!-- Error Message -->
            <%
                String errorMessage = (String) request.getAttribute("errorMessage");
                if (errorMessage != null) {
            %>
            <div class="alert alert-danger mt-3 text-center" role="alert" style="margin: 0; border-radius: 0;">
                <%= errorMessage %>
            </div>
            <% } %>
        </div>
    </div>
</div>



















</body>




</html>