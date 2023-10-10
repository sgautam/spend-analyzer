$(document).ready(function() {
    
    google.charts.load('current', {'packages':['corechart']});
    google.charts.setOnLoadCallback(drawChart);

    function drawChart() {

    var data = google.visualization.arrayToDataTable([
        ['Task', 'Groceries'],
        ['Supermarket',     2],
        ['Entertainment',      2],
        ['Travel',  2],
        ['Gas', 1],
        ['Healthcare',    7],
        ['Medicine',    7],
        ['Clothing',    7],
        ['Housing',    7],
        ['Investments',    7],
        ['Education',    7],
        ['Childcare',    7],
        ['Savings',    7],
        ['Insurance',    7],
        ['Transportation',    7],
        ['Water',    7],
        ['Electricity',    7],
        ['Subsciptions',    7],
        ['Tuition',    7],
        ['Car Payments',    7],

    ]);

    var options = {
        //title: 'My Daily Activities'
    };

    var chart = new google.visualization.PieChart(document.getElementById('piechart'));

    chart.draw(data, options);
    }

    $('.add-transaction-btn').on('click', function(e){
        e.preventDefault();
        
    });

});

$(document).ajaxStart(function() {
    $( '.ajax-spinner' ).show();
});

$(document).ajaxStop(function() {
    $( '.ajax-spinner' ).hide();
});