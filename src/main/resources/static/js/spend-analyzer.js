  $(document).ready(function() {
  
    function initTable (category) {
        return $('#transactionTable').dataTable( {
            "paginate": true,
            "retrieve": true,
            "ajax": {
                "url": "/transactions",
                "contentType": "application/json",
                "type": "GET",
                "data": function(d){
                    d.category=category
                },
                "dataSrc": ''
            },
            "columns": [
                { "data": 'id' },
                { "data": 'category' },
                { "data": 'description' },
                { "data": 'amount' },
                { "data": 'date' }
            ]
        });
      }
      
    let table = initTable('all');

    let hideMessage = function (){
        $(".error").remove();
        $(".alert-info").hide();
        $(".alert-danger").hide();
    };
    
    google.charts.load('current', {'packages':['corechart']});
    google.charts.setOnLoadCallback(drawChart);

    let getCategories = function(categoryDataRow){
        $.get({
            url: "/categories",
            async: false,
            success: function(data){
               let rows = [];
               $.each(data, function(idx, value){
                    rows.push([value.category, value.count])
               });
               categoryDataRow.addRows(rows);
            },
            error: function(error){
                $('.alert-danger').show();
                $('.error-msg').before('<span class="error">Failed to add a transaction... try again later.</span>');
            }
        });

    };

    


    function  drawChart(){
        let data = new google.visualization.DataTable();
        data.addColumn('string', 'Category');
        data.addColumn('number', 'Count');
        getCategories(data); // load data from API call
        let chart = new google.visualization.PieChart(document.getElementById('piechart'));
        
        let selectHandler = function() {
            var selectedItem = chart.getSelection()[0];
            if (selectedItem) {
                let category = data.getValue(selectedItem.row, 0);
                table = initTable(category);
                console.log('Selected category is '+ category);
            }
          };

        google.visualization.events.addListener(chart, 'select', selectHandler);
       
        let options = {};
        chart.draw(data, options);
    }
   

    $('.add-transaction-btn').on('click', function(e){
        e.preventDefault();
        hideMessage();
        $.post({
            url: $('#addTransactionForm').attr('action'),
            data: $('#addTransactionForm').serialize(),
            success: function(data){
                $('.alert-info').show();
                $('.info-msg').before('<span class="error">Successfully added transaction for category [' + data.category + '].</span>');
                table = initTable('all');

            },
            error: function(error){
                $('.alert-danger').show();
                $('.error-msg').before('<span class="error">Failed to add a transaction... try again later.</span>');
            }

        });

    });

    
    
});

$(document).ajaxStart(function() {
    $( '.ajax-spinner' ).show();
});

$(document).ajaxStop(function() {
    $( '.ajax-spinner' ).hide();
});