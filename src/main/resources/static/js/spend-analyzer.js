$(document).ready(function() {

    let hideMessage = function (){
        $(".error").remove();
        $(".alert-info").hide();
        $(".alert-danger").hide();
    };
    
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
        hideMessage();
        $.post({
            url: $('#addTransactionForm').attr('action'),
            data: $('#addTransactionForm').serialize(),
            success: function(data){
                $('.alert-info').show();
                $('.info-msg').before('<span class="error">Successfully added transaction for category [' + data.category + '].</span>');
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