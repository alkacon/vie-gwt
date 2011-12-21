jQuery(document).ready(function() {
  var saveButton = null;
  var changedEntities = [];

  var v = new VIE();
  v.use(new v.RdfaService);
  v.entities.bind('add', function(entity) {
    jQuery('[about="' + entity.getSubjectUri() + '"] [property]').each(function() {
      if (v.services.rdfa.getElementSubject(this) !== entity.id) {
        return;
      }
      var editableElement = jQuery(this);
      var property = v.services.rdfa.getElementPredicate(this);
      editableElement.attr('contenteditable', true);
      editableElement.bind('keyup click change', function() {
        var content = editableElement.html();
        if (content !== entity.get(property)) {
          var changedProps = {};
          changedProps[property] = content;
          entity.set(changedProps);
        }
      });
    });

    entity.bind('change', function() {
      console.log(entity.previousAttributes(), entity.attributes);
      if (changedEntities.indexOf(entity) === -1) {
        changedEntities.push(entity);
      }
      if (saveButton) {
        return;
      }

      saveButton = jQuery('<button>Save</button>');
      saveButton.click(function() {
        alert('We would save ' + changedEntities.length + ' changed entities');
        _.each(changedEntities, function(entity) {
          //entity.save();
        });
        changedEntities = [];
      });
      jQuery('body').append(saveButton);
    });
  });
  v.load({element: 'body'}).using('rdfa').execute();
});