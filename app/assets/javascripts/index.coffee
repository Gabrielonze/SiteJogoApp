$ ->
  $.get "/gamelist", (data) ->
    $.each data, (index, item) ->
      $("#games").append $("<li>").text item.name