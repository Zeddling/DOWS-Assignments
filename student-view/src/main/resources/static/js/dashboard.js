$(document).ready(function() {
    $('#view-btn').bind('click', function(){
        var regex = /^([a-zA-Z0-9\s_\\.\-:])+(.csv)$/;
        if ( regex.test($('#file').val().toLowerCase()) ){
            if (typeof (FileReader) != "undefined") {
                var reader = new FileReader();
                reader.onload = function (e) {
                    var table = "<table class='table table-bordered table-striped' >";
                    var allRows = e.target.result.split(/\r?\n|\r/);
                    for (var singleRow = 0; singleRow < allRows.length; singleRow++) {
                        if (singleRow === 0) {
                          table += '<thead>';
                          table += '<tr>';
                        } else {
                          table += '<tr>';
                        }
                        var rowCells = allRows[singleRow].split(',');
                        for (var rowCell = 0; rowCell < rowCells.length; rowCell++) {
                          if (singleRow === 0) {
                            table += '<th>';
                            table += rowCells[rowCell];
                            table += '</th>';
                          } else {
                            table += '<td>';
                            table += rowCells[rowCell];
                            table += '</td>';
                          }
                        }
                        if (singleRow === 0) {
                          table += '</tr>';
                          table += '</thead>';
                          table += '<tbody>';
                        } else {
                          table += '</tr>';
                        }
                      }
                      table += '</tbody>';
                      table += '</table>';
                      $('#product-table').append(table)
                }
                reader.readAsText($("#file")[0].files[0]);
            }  else {
                alert("This browser does not support HTML5.");
            }
        }else {
            alert("Please upload a valid CSV file.");
        }
    });
});