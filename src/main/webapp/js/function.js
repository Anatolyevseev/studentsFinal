

function deleteDiscipline() {
    var items = $("input[type=checkbox]:checked")
    if (items.length == 0) {
        alert("Please select at least one discipline!");
        return;
    }

    var idsSelected = "";
    for (var i = 0; i < items.length; ++i) {
        idsSelected = idsSelected + $(items[i]).attr("value") + ",";
    }

    $("#idsDisc").val(idsSelected);
    $('#delete-discipline-form').submit();

}

function modifyDiscipline() {
    var items11 = $("input[type=checkbox]:checked")
    if (items11.length == 0) {
        alert("Please select at least one discipline!");
        return;
    }
    if (items11.length > 1) {
        alert("Please select only one discipline!");
        return;
    }
    var idSelected = $(items11[0]).attr("value");

    $("#modifyId").val(idSelected);
    $('#discipline-modify-form').submit();
}

function deleteStudent() {
    var itemst = $("input[type=checkbox]:checked")
    if (itemst.length == 0) {
        alert("Please select at least one student!");
        return;
    }

    var idstSelected = "";
    for (var i = 0; i < itemst.length; ++i) {
        idstSelected = idstSelected + $(itemst[i]).attr("value") + ",";
    }

    $("#idstud").val(idstSelected);
    $('#delete-student-form').submit();

}

function modifyStudent() {
    var items = $("input[type=checkbox]:checked")
    if (items.length == 0) {
        alert("Please select at least one discipline!");
        return;
    }

    if (items.length > 1) {
        alert("Please select only one discipline!");
        return;
    }

    var idSelected = $(items[0]).attr("value");

    $("#modifystId").val(idSelected);
    $('#discipline-modify-form').submit();
}