mdb.Alert.getInstance(document.getElementById("alertExample")).update({
      position: "top-right",
      delay: 2000,
      autohide: false,
      width: "600px",
      offset: 20,
      stacking: false,
      appendToBody: false,
    });



    $(document).ready(function(){
    	// Activate tooltip
    	$('[data-toggle="tooltip"]').tooltip();

    	// Select/Deselect checkboxes
    	var checkbox = $('table tbody input[type="checkbox"]');
    	$("#selectAll").click(function(){
    		if(this.checked){
    			checkbox.each(function(){
    				this.checked = true;
    			});
    		} else{
    			checkbox.each(function(){
    				this.checked = false;
    			});
    		}
    	});
    	checkbox.click(function(){
    		if(!this.checked){
    			$("#selectAll").prop("checked", false);
    		}
    	});
    });