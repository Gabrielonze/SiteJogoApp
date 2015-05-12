$ ->
  $.get "/barsl", (data) ->
    $.each data, (catalogo, item) ->
      $("#bars").append $("<li>").text item.name