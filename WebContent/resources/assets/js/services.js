app.factory('Page', function(){
	var title = "iMake Web";
	return {
		title : function(){
			return title;
		},
		setTitle : function(newTitle){
			title = newTitle;
			
		}
	}
});