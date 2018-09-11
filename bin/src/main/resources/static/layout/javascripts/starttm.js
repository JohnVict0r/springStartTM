var starttm = starttm || {};

starttm.onSidebarToggleRequest = function(event) {
  event.preventDefault();
  $(this).blur();

  $('.js-sidebar, .js-content').toggleClass('is-toggled');
};

starttm.initMenu = function() {
  $('.js-menu > ul > li > a').bind('click', starttm.onMenuGroupClick);
  $('.starttm-menu__item .is-active').parents('.starttm-menu__item').addClass('is-expanded is-active');
};

$(function() {
  starttm.initMenu();
  
  // Enable Bootstrap tooltip
  $('.js-tooltip').tooltip();
  
  // Bind events
  $('.js-sidebar-toggle').bind('click', starttm.onSidebarToggleRequest);
  
  $('.js-currency').maskNumber({
	  decimal: ',',
	  thousands: '.'
  });
});