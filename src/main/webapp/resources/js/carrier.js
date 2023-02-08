
var carrierId = null;

$(function () {
    updateAllTableRows();

    $('#carrierModal').on('show.bs.modal', function (event) {
        var modal = $(this);
        if (carrierId !== null) {
            // FOR UPDATE
            $.ajax({
                type: 'GET',
                url: '/RestSpringTest/carriers/' + carrierId,
                success: function (data) {
                    modal.find('#carrierModalLabel').text('Изменить перевозчика');
                    modal.find('#modal-button-save').text('Сохранить');
                    modal.find('#modal-carrier-id').val(data.id);
                    modal.find('#modal-carrier-name').val(data.name);
                    modal.find('#modal-carrier-inn').val(data.inn);
                    modal.find('#modal-carrier-regAddress').val(data.regAddress);
                    modal.find('#modal-carrier-country').val(data.country.id);
                    modal.find('#modal-carrier-taxSystem').val(data.taxSystem.id);
                },
                error: errorHandler()
            });
        } else {
            // FOR INSERT
            modal.find('#carrierModalLabel').text('Новый перевозчик');
            modal.find('#modal-button-save').text('Добавить');
            modal.find('#modal-carrier-id').val('');
            modal.find('#modal-carrier-name').val('');
            modal.find('#modal-carrier-inn').val('');
            modal.find('#modal-carrier-regAddress').val('');
            modal.find("#modal-carrier-country")[0].selectedIndex = 0;
            modal.find("#modal-carrier-taxSystem")[0].selectedIndex = 0;
        }
    });
});

function showModalForInsert() {
    this.carrierId = null;
    $('#carrierModal').modal('show');
}

function showModalForUpdate(carrierId) {
    this.carrierId = carrierId;
    $('#carrierModal').modal('show');
}

function insertOrUpdateCarrier() {
    var dataFrom = $('#form-carrier').find('input, select')
            .not('[value=""]')
            .serialize();
    $.ajax({
        type: 'POST',
        url: '/RestSpringTest/ajax/carriers',
        data: dataFrom,
//        data: $('#form-carrier').serialize(),
        success: function (data) {
            $('#carrierModal').modal('hide');
            notySucces(carrierId === null ? 'Запись добавлена' : 'Запись изменена');
            updateAllTableRows();
        },
        error: errorHandler()
    });
}

function showConfirmDeleteCarrier(carrierId) {
    notyConfirm("Удалить запись?", function () {
        deleteCarrier(carrierId);
    });
}

function deleteCarrier(carrierId) {
    $.ajax({
        type: 'DELETE',
        url: '/RestSpringTest/carriers/' + carrierId,
        success: function (data) {
            notySucces('Запись удалена');
            removeTableRow(carrierId);
        },
        error: errorHandler()
    });
}

// ########################## TABLE ##########################

function removeTableRow(carrierId) {
    var rowId = '#table-row-' + carrierId;
    $(rowId).remove();
}

function updateAllTableRows() {
    $.ajax({
        type: 'GET',
        url: '/RestSpringTest/carriers',
        success: function (data) {
            var tbody = $('#tbody-carriers');
            tbody.html('');
            for (var i = 0; i < data.length; i++) {
                var carrier = data[i];
                var row = carrierToTableRow(carrier);
                tbody.append(row);
            }
        },
        error: errorHandler()
    });
}

function carrierToTableRow(carrier) {
    return `
        <tr id="table-row-${carrier.id}">  
            <td>${formatNotNull(carrier.name)}</td>
            <td>${formatNotNull(carrier.inn)}</td>
            <td>${formatNotNull(carrier.regAddress)}</td>
            <td>${formatNotNull(carrier.country.name)}</td> 
            <td>${formatNotNull(carrier.taxSystem.name)}</td>
            <td> 
                <a class="btn btn-primary btn-sm" role="button" onclick="showModalForUpdate(${carrier.id})"> 
                    Изменить
                </a>  
                <a class="btn btn-danger btn-sm" role="button" onclick="showConfirmDeleteCarrier(${carrier.id})"> 
                    Удалить
                </a>
            </td>
        </tr>
    `;
}

// ########################## FORMAT DATA ##########################

function formatNotNull(value) {
    return value === null ? '' : value;
}

//function formatTaxSystem(value) {
//    if (value === '' || value === null) {
//        return 'Без НДС';
//    } else if (value >= 0) {
//        return 'НДС ' + value + '%';
//    } else {
//        return '';
//    }
//}

// ########################## NOTIFY ##########################

function errorHandler() {
    return function notyException(xhr, status, error) {
        notyError('code: ' + xhr.status + '</br>status: ' + status + '</br>error: ' + xhr.responseText);
    };
}

function notyConfirm(msg, onConfirm) {
    var n = new Noty({
        text: msg,
        layout: 'center', 
        modal: true,
        buttons: [
            Noty.button('Да', 'btn btn-success', function () {
                onConfirm();
                n.close();
            }, {id: 'button1', 'data-status': 'ok'}),

            Noty.button('Нет', 'btn btn-error', function () {
                n.close();
            })
        ]
    });
    n.show();
}

function notyError(text) {
    showNoty('error', 5, text);
}

function notySucces(text) {
    showNoty('success', 3, text);
}
 
function showNoty(type, timeoutSeconds, text) {
    Noty.closeAll();
    new Noty({
        layout: 'topCenter',
        type: type,
        text: text,
        timeout: timeoutSeconds * 1000
    }).show(); 
}
