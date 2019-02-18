$("#department").change(function () {
    var departmentId = $(this).val();
    $.ajax({
        type: "GET",
        url: "/admin/department/" + departmentId + "/majors",
        success: function (data) {
            var majors = $('#major');
            var option = "";
            majors.empty();

            for (var i = 0; i < data.length; i++) {
                option = option + "<option value=\"" + data[i].majorNumber + "\" name=\"major.majorNumber\">" + data[i].majorName + "</option>";
            }
            majors.append(option);
        },
        error: function () {
            console.log("Error to achieve major information");
        }
    });
});