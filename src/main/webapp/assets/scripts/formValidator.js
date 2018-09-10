function validateForm() {
    var isValidate = true;

    var form = document.getElementById('main-form')
    var components = form.getElementsByTagName('input');

    if(components.length == 1) {
        isValidate = false;
        addAlertMessage("You have to add at least one component", "alert-danger")
    }

    var soups = getSoupsFromDatabase();
    if(soups.contains(components[0].value)) {
        isValidate = false;
        addAlertMessage("Meal with this name already exist", "alert-danger");
    }

    for(let i=0; i<components.length; i++) {
        if(components[i].value.length == 0) {
            isValidate = false;
            addAlertMessage("There is at least one empty meal or component field", "alert-danger")
        }
    }

    if(isValidate) {
        addAlertMessage("Succesfully added to database", "alert-primary")
        setTimeout(function(){ form.submit() }, 2000);
    }

}