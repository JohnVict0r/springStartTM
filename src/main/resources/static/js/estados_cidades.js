$(document).ready(function () {

	var options = '<option value="">---Selecione um estado---</option>';
	$.each(estadosCidadesJson.estados, function (key, val) {
		options += '<option value="' + val.nome + '">' + val.nome + '</option>';
	});

	$("#estados").html(options);

	$("#estados").change(function () {

		var options_cidades = '<option>---Selecione uma Cidade---</option>';
		var str = "";

		$("#estados option:selected").each(function () {
			str += $(this).text();
		});

		$.each(estadosCidadesJson.estados, function (key, val) {
			if(val.nome == str) {
				$.each(val.cidades, function (key_city, val_city) {
					options_cidades += '<option value="' + val_city + '">' + val_city + '</option>';
				});
			}
		});
		$("#cidades").html(options_cidades);

	}).change();

});
