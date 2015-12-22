
var ProjectsService = {
  loadProjects: function (userId, callback) {
    $.ajax({
      url: host + "/api/v1/users/"+userId+"/projects",
      dataType: 'json'
    })
    .done(function (msg) {
      console.log(msg);
    })
    .success(function (msg) {
      console.log(msg);
      if (callback) {
        callback(msg);
      }
    })
    .fail(function (jqXHR, textStatus) {
      console.log(textStatus);
    });
  },

  createProject: function (userId, projectName, callback) {
    $.ajax({
      method: "PUT",
      url: host + "/api/v1/users/"+userId+"/projects/"+projectName,
      dataType: 'json',
      contentType: 'application/json',
      data: JSON.stringify({
        id: projectName,
        name: projectName
      })
    })
      .success(function (msg) {
        console.log(msg);
        if (callback) {
          callback(msg);
        }
      })
      .fail(function (jqXHR, textStatus) {
        console.log(textStatus);
      })
      .done(function (msg) {
        console.log(msg);
      });
  },

  launchGeneration: function (userId, projectName, callback) {
    var modelName = "employees";
    var bundleName = "bundle_java";
    $.ajax({
      method: "GET",
      url: host + "/api/v1/users/"+userId+"/projects/"+projectName+"/model/"+modelName+"/bundle/"+bundleName+"/action/generate",
      dataType: 'json'
    })
      .success(function (msg) {
        console.log(msg);
        if (callback) {
          callback(msg);
        }
      })
      .fail(function (jqXHR, textStatus) {
        console.log(textStatus);
      })
      .done(function (msg) {
        console.log(msg);
      });
  }

};
