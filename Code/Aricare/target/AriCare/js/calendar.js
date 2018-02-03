function calendarpick() 
{
	$( "#datepicker-13" ).datepicker(
	{
		dateFormat: "yy-mm-dd",
		minDate:1,
		maxDate:"14D",
		beforeShowDay : function (date)
		{
			var dayOfWeek = date.getDay ();
			// 0 : Sunday, 1 : Monday, ...
			if (dayOfWeek == 0 || dayOfWeek == 6) return [false];
			else return [true];
		}
	});
}