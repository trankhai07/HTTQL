import React, { useEffect, useState } from 'react';
import { useLocation, useNavigate, useParams } from 'react-router-dom';
import { Modal, ModalHeader, ModalBody, ModalFooter, Button } from 'reactstrap';

import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { useAppDispatch, useAppSelector } from 'app/config/store';
import { getEntity, deleteEntity } from './order-customer-of-city-cube.reducer';

export const OrderCustomerOfCityCubeDeleteDialog = () => {
  const dispatch = useAppDispatch();

  const location = useLocation();
  const navigate = useNavigate();
  const { id } = useParams<'id'>();

  const [loadModal, setLoadModal] = useState(false);

  useEffect(() => {
    dispatch(getEntity(id));
    setLoadModal(true);
  }, []);

  const orderCustomerOfCityCubeEntity = useAppSelector(state => state.orderCustomerOfCityCube.entity);
  const updateSuccess = useAppSelector(state => state.orderCustomerOfCityCube.updateSuccess);

  const handleClose = () => {
    navigate('/order-customer-of-city-cube' + location.search);
  };

  useEffect(() => {
    if (updateSuccess && loadModal) {
      handleClose();
      setLoadModal(false);
    }
  }, [updateSuccess]);

  const confirmDelete = () => {
    dispatch(deleteEntity(orderCustomerOfCityCubeEntity.cityName));
  };

  return (
    <Modal isOpen toggle={handleClose}>
      <ModalHeader toggle={handleClose} data-cy="orderCustomerOfCityCubeDeleteDialogHeading">
        Confirm delete operation
      </ModalHeader>
      <ModalBody id="httqlApp.orderCustomerOfCityCube.delete.question">
        Are you sure you want to delete Order Customer Of City Cube {orderCustomerOfCityCubeEntity.cityName}?
      </ModalBody>
      <ModalFooter>
        <Button color="secondary" onClick={handleClose}>
          <FontAwesomeIcon icon="ban" />
          &nbsp; Cancel
        </Button>
        <Button id="jhi-confirm-delete-orderCustomerOfCityCube" data-cy="entityConfirmDeleteButton" color="danger" onClick={confirmDelete}>
          <FontAwesomeIcon icon="trash" />
          &nbsp; Delete
        </Button>
      </ModalFooter>
    </Modal>
  );
};

export default OrderCustomerOfCityCubeDeleteDialog;
