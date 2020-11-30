var decodedChartDataString = decodeHtml(chartData);
var chartJsonArray = JSON.parse(decodedChartDataString); 

var chartArrayLength = chartJsonArray.length;

var valueData = [];
var labelData = [];

for(var i = 0; i < chartArrayLength; i++) {
	valueData[i] = chartJsonArray[i].value;
	labelData[i] = chartJsonArray[i].label;
}

new Chart(document.getElementById("myPieChart"), {
    type: 'pie',
     // The data for our dataset
    data: {
        labels: labelData,
        datasets: [{
            label: 'My First dataset',
            backgroundColor: ["#3e95cd", "#8e5ea2", "#3cba9f"],
            data: valueData
        }]
    },

    // Configuration options go here
    options: {
    	title: {
    		display: true,
    		text: 'Project Statuses'
    	}
    }
});

function decodeHtml(html) {
	var txt = document.createElement("textarea");
	txt.innerHTML = html;
	return txt.value;
}