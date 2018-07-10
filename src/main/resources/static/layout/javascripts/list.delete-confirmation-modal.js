var Eventos = evento || {};

Eventos.DeleteConfirmatioModal = (function() {
	function DeleteConfirmatioModal() {
		this.modal = $('#deleteConfirmationModal');
		this.form = this.modal.find('form');
	}
	
	DeleteConfirmatioModal.prototype.initiate = function() {
		this.modal.on('show.bs.modal', showBsModal.bind(this));		
	}
	
	function showBsModal(event) {
		var button = $(event.relatedTarget);
		var name = button.data('name');
		var url = button.data('url-delete')
		
		this.modal.find('.modal-body span').html('tem certeza que deseja excluir <strong>'+name+'</sstrong>?');
		
		this.form.attr('action', url);
	}
	
	return DeleteConfirmatioModal;
}());

$(function () {
	var deleteConfirmatioModal = new Eventos.DeleteConfirmatioModal();
	deleteConfirmatioModal.initiate();
});