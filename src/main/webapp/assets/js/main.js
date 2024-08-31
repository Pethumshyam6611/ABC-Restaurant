(function() {
  "use strict";

  /**
   * Apply .scrolled class to the body as the page is scrolled down
   */
  function toggleScrolled() {
    var selectBody = document.querySelector('body');
    var selectHeader = document.querySelector('#header');
    if (!selectHeader.classList.contains('scroll-up-sticky') && !selectHeader.classList.contains('sticky-top') && !selectHeader.classList.contains('fixed-top')) return;
    window.scrollY > 100 ? selectBody.classList.add('scrolled') : selectBody.classList.remove('scrolled');
  }

  document.addEventListener('scroll', toggleScrolled);
  window.addEventListener('load', toggleScrolled);

  /**
   * Mobile nav toggle
   */
  var mobileNavToggleBtn = document.querySelector('.mobile-nav-toggle');

  function mobileNavToogle() {
    document.querySelector('body').classList.toggle('mobile-nav-active');
    mobileNavToggleBtn.classList.toggle('bi-list');
    mobileNavToggleBtn.classList.toggle('bi-x');
  }
  if (mobileNavToggleBtn) {
    mobileNavToggleBtn.addEventListener('click', mobileNavToogle);
  }

  /**
   * Hide mobile nav on same-page/hash links
   */
  var navMenuLinks = document.querySelectorAll('#navmenu a');
  navMenuLinks.forEach(function(navmenu) {
    navmenu.addEventListener('click', function() {
      if (document.querySelector('.mobile-nav-active')) {
        mobileNavToogle();
      }
    });
  });

  /**
   * Toggle mobile nav dropdowns
   */
  var navMenuDropdowns = document.querySelectorAll('.navmenu .toggle-dropdown');
  navMenuDropdowns.forEach(function(navmenu) {
    navmenu.addEventListener('click', function(e) {
      e.preventDefault();
      this.parentNode.classList.toggle('active');
      this.parentNode.nextElementSibling.classList.toggle('dropdown-active');
      e.stopImmediatePropagation();
    });
  });

  /**
   * Preloader
   */
  var preloader = document.querySelector('#preloader');
  if (preloader) {
    window.addEventListener('load', function() {
      preloader.parentNode.removeChild(preloader);
    });
  }

  /**
   * Scroll top button
   */
  var scrollTop = document.querySelector('.scroll-top');

  function toggleScrollTop() {
    if (scrollTop) {
      window.scrollY > 100 ? scrollTop.classList.add('active') : scrollTop.classList.remove('active');
    }
  }
  if (scrollTop) {
    scrollTop.addEventListener('click', function(e) {
      e.preventDefault();
      window.scrollTo({
        top: 0,
        behavior: 'smooth'
      });
    });
  }

  window.addEventListener('load', toggleScrollTop);
  document.addEventListener('scroll', toggleScrollTop);

  /**
   * Animation on scroll function and init
   */
  function aosInit() {
    if (window.AOS) {
      window.AOS.init({
        duration: 600,
        easing: 'ease-in-out',
        once: true,
        mirror: false
      });
    }
  }
  window.addEventListener('load', aosInit);

  /**
   * Auto generate the carousel indicators
   */
  var carouselIndicators = document.querySelectorAll('.carousel-indicators');
  carouselIndicators.forEach(function(carouselIndicator) {
    var carouselItems = carouselIndicator.closest('.carousel').querySelectorAll('.carousel-item');
    carouselItems.forEach(function(carouselItem, index) {
      var li = document.createElement('li');
      li.setAttribute('data-bs-target', '#' + carouselIndicator.closest('.carousel').id);
      li.setAttribute('data-bs-slide-to', index);
      if (index === 0) {
        li.classList.add('active');
      }
      carouselIndicator.appendChild(li);
    });
  });

  /**
   * Initiate glightbox
   */
  if (window.GLightbox) {
    var glightbox = window.GLightbox({
      selector: '.glightbox'
    });
  }

  /**
   * Init isotope layout and filters
   */
  var isotopeLayouts = document.querySelectorAll('.isotope-layout');
  isotopeLayouts.forEach(function(isotopeItem) {
    var layout = isotopeItem.getAttribute('data-layout') || 'masonry';
    var filter = isotopeItem.getAttribute('data-default-filter') || '*';
    var sort = isotopeItem.getAttribute('data-sort') || 'original-order';

    var initIsotope;
    if (window.imagesLoaded && window.Isotope) {
      window.imagesLoaded(isotopeItem.querySelector('.isotope-container'), function() {
        initIsotope = new window.Isotope(isotopeItem.querySelector('.isotope-container'), {
          itemSelector: '.isotope-item',
          layoutMode: layout,
          filter: filter,
          sortBy: sort
        });
      });

      var isotopeFilters = isotopeItem.querySelectorAll('.isotope-filters li');
      isotopeFilters.forEach(function(filterItem) {
        filterItem.addEventListener('click', function() {
          isotopeItem.querySelector('.filter-active').classList.remove('filter-active');
          this.classList.add('filter-active');
          initIsotope.arrange({
            filter: this.getAttribute('data-filter')
          });
          if (typeof aosInit === 'function') {
            aosInit();
          }
        });
      });
    }
  });

  /**
   * Init swiper sliders
   */
  function initSwiper() {
    var swiperElements = document.querySelectorAll(".init-swiper");
    swiperElements.forEach(function(swiperElement) {
      var configElement = swiperElement.querySelector(".swiper-config");
      if (configElement) {
        var config = JSON.parse(configElement.innerHTML.trim());
        if (window.Swiper) {
          new window.Swiper(swiperElement, config);
        }
      }
    });
  }

  window.addEventListener("load", initSwiper);

  /**
   * Correct scrolling position upon page load for URLs containing hash links.
   */
  window.addEventListener('load', function() {
    if (window.location.hash) {
      var section = document.querySelector(window.location.hash);
      if (section) {
        setTimeout(function() {
          var scrollMarginTop = window.getComputedStyle(section).scrollMarginTop;
          window.scrollTo({
            top: section.offsetTop - parseInt(scrollMarginTop),
            behavior: 'smooth'
          });
        }, 100);
      }
    }
  });

  /**
   * Navmenu Scrollspy
   */
  var navmenulinks = document.querySelectorAll('.navmenu a');

  function navmenuScrollspy() {
    navmenulinks.forEach(function(navmenulink) {
      if (!navmenulink.hash) return;
      var section = document.querySelector(navmenulink.hash);
      if (!section) return;
      var position = window.scrollY + 200;
      if (position >= section.offsetTop && position <= (section.offsetTop + section.offsetHeight)) {
        document.querySelectorAll('.navmenu a.active').forEach(function(link) {
          link.classList.remove('active');
        });
        navmenulink.classList.add('active');
      } else {
        navmenulink.classList.remove('active');
      }
    });
  }
  window.addEventListener('load', navmenuScrollspy);
  document.addEventListener('scroll', navmenuScrollspy);

})();
