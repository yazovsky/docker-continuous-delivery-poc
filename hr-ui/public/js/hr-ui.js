var ctx = document.getElementById("myChart").getContext("2d");

data.datasets[0].fillColor="rgba(151,187,205,0.2)";
data.datasets[0].strokeColor="rgba(151,187,205,1)";
data.datasets[0].pointColor="rgba(151,187,205,1)";
data.datasets[0].pointStrokeColor="#fff";
data.datasets[0].pointHighlightFill="#fff";
data.datasets[0].pointHighlightStroke="rgba(151,187,205,1)";

new Chart(ctx).Line(data);
