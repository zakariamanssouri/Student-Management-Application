function deleteStudent(event, me) {
    event.preventDefault();
    return Swal.fire({
        title: 'Are you sure?',
        text: "You won't be able to revert this!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, delete it!'
    }).then(function (result) {
        if(result.isConfirmed){
            $(me).parent().submit()
        }
    });
}

/*
$('.delete-confirm').on('click',function (e) {
    e.preventDefault();
    Swal.fire({
        title: 'Are you sure?',
        text: "You won't be able to revert this!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, delete it!'
    }).then(function (result) {
        if (result.isConfirmed) {
            $('.delete-confirm').closest('form').submit();
        Swal.fire(
            'Deleted!',
            'Your file has been deleted.',
            'success'
        )
    }
})
});
*/
