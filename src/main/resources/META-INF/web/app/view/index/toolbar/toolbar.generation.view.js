var ToolbarGeneration = {

  init: function() {
  },

  openModal: function() {
    var html =
      '<div id="generationModal" class="modal modal-fixed-footer"></div>';
    $('#generation').html(html);
    $('#generationModal').openModal();

    this.loadData(function() {
      this.displayModal();
    }.bind(this));
  },

  loadData: function(callback) {
    var state = Store.getState();

    ProjectsService.getBundlesOfProject(state.auth.userId, state.projectId, function(bundlesOfProject) {
      state.bundlesOfProject = bundlesOfProject;

      ProjectsService.getModels(state.auth.userId, state.projectId, function (models) {
        state.models = models;
        console.log(models);
        if (callback) {
          callback();
        }
      });
    });
  },

  displayModal: function() {
    var state = Store.getState();

    var html =
      '<div class="modal-content">' +
        '<h4>Generation</h4>' +
        '<div class="row">' +
          '<div class="input-field col s6">' +
            'Entities';

    for(var i=0; i<state.models.length; i++) {
      var model = state.models[i];
      for(var j=0; j<model.entities.length; j++) {
        var entity = model.entities[j];
        html +=
          '<div>' +
            '<input type="checkbox" checked name="generation_entities" value="' + model.modelName + '/' + entity.fullName + '" id="' + model.modelName + '__' + entity.fullName + '" />' +
            '<label for="' + model.modelName + '__' + entity.fullName + '">' + model.modelName+'/'+entity.fullName + '</label>' +
          '</div>';
      }
    }

    html +=
          '</div>' +
          '<div class="input-field col s6">' +
            'Templates bundles';

    for(var i=0; i<state.bundlesOfProject.length; i++) {
      var bundle = state.bundlesOfProject[i];
      html +=
        '<div>' +
          '<input type="checkbox" checked name="generation_bundles" value="' + bundle.name + '" id="' + bundle.name + '" />' +
          '<label for="' + bundle.name + '">' + bundle.name + '</label>' +
        '</div>';
    }

    html +=
          '</div>' +
        '</div>' +
      '</div>' +
      '<div class="modal-footer">' +
        '<a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat" onclick="ToolbarGeneration.submitGeneration()">Generate</a>' +
        '<a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat" onclick="ToolbarGeneration.closeModal()">Cancel</a>' +
      '</div>';

    $('#generationModal').html(html);
  },

  closeModal: function() {
    $('#generationModal').closeModal();
  },

  submitGeneration: function() {
    var entitiesByModels = {};
    var entitiesFields = document.getElementsByName('generation_entities')
    for(var i=0; i<entitiesFields.length; i++) {
      var entityField = entitiesFields[i];
      if(entityField.checked) {
        var value = entityField.value;
        var model = value.substring(0,value.indexOf('/'));
        var entity = value.substring(value.indexOf('/')+1);
        if(entitiesByModels[model] == null) {
          entitiesByModels[model] = [];
        }
        entitiesByModels[model].push(entity);
      }
    }
    console.log('entitiesByModels', entitiesByModels);
    var bundles = [];
    var bundlesFields = document.getElementsByName('generation_bundles')
    for(var i=0; i<bundlesFields.length; i++) {
      var bundleField = bundlesFields[i];
      if(bundleField.checked) {
        bundles.push(bundleField.value);
      }
    }
    console.log('bundles', bundles);

    var state = Store.getState();
    state.generation = {
      entitiesByModels: entitiesByModels,
      bundles: bundles
    };

    this.launchGeneration();
  },

  launchGeneration: function() {
    var state = Store.getState();
    if(!state.generation) {
      return;
    }
    var entitiesByModels = state.generation.entitiesByModels;
    var bundles = state.generation.bundles;

    state.generationResults = [];
    var generations = [];
    for(var model in entitiesByModels) {
      var entities = entitiesByModels[model];
      for (var i = 0; i < bundles.length; i++) {
        var bundle = bundles[i];
        var generation = {
          model: model,
          entities: entities,
          bundle: bundle
        };
        console.log('generation: ', generation);
        generations.push(generation);
      }
    }

    // do only one generation at times
    var i = 0;
    if(i<generations.length) {
      var generation = generations[i];

      var launchGenerationCallbackEnd = (function() {
        // close modal and refresh at the end
        this.closeModal();
        IDETreeview.refreshAll();
        IDEWorkingFiles.refreshAll();
      }.bind(this));

      var launchGenerationCallback = (function launchGenerationCallback(result) {
        console.log(result);
        state.generationResults.push(result);
        IDEConsoleGeneration.display();

        // next generation
        i++;
        if (i < generations.length) {
          var generation = generations[i];
          ProjectsService.launchGeneration(state.auth.userId, state.projectId, generation, launchGenerationCallback);
        } else {
          launchGenerationCallbackEnd();
        }
      }.bind(this));

      ProjectsService.launchGeneration(state.auth.userId, state.projectId, generation, launchGenerationCallback);
    }
    //IDE.defineSplitEditorGenerate(40);
  }

};