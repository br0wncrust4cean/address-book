var addBuddy = function(event) {
  event.preventDefault();
  console.log(convertToJson($("#buddyForm").serializeArray()));
  $.ajax({
      type:"POST",
      contentType: "application/json; charset=utf-8",
      data: convertToJson($("#buddyForm").serializeArray()),
      datatype:"json",
      url:"http://localhost:8080/buddy"
  }).then(function(data){
      console.log(data);
      var buddyRow = "<tr><td>" + data.name + "</td><td>"+data.address+"</td><td>"+data.phoneNumber+"</td></tr>";
      $("#buddyRow").append(buddyRow);
  });
};

var convertToJson = function(data) {
    var json = {};
    json["name"] = data[0].value;
    json["phoneNumber"] = data[2].value;
    json["address"] = data[1].value;

    return JSON.stringify(json);
}
