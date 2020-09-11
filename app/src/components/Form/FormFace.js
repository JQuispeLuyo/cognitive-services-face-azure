import React, { useState } from 'react'
import { Button, Form, Segment } from 'semantic-ui-react';

const FormFace = ({ handleSubmit, loading }) => {

    const [value, setvalue] = useState({ file: null });

    const handleChange = ({ target }) => {
        console.log(target);
        if(target.files[0]){
            setvalue({ [target.name]: URL.createObjectURL(target.files[0]) })
        }else{
            setvalue({ [target.name]: null})
        }
        console.log(value);
    }

    return (
        <Form size='large' onSubmit={handleSubmit} encType="multipart/form-data" >
            <Segment stacked>
                {
                    value.file
                        ? <img
                            src={value.file}
                            alt={`Face`}
                            style={{ maxWidth: 250 }}
                        />
                        : ''
                }
               <hr/> 
                {
                    loading
                        ? 'Loading...'
                        :
                        <div>
                            <Form.Input
                                type="file"
                                name="file"
                                fluid icon='photo'
                                iconPosition='left'
                                onChange={handleChange}
                            />
                            <Button
                                color='teal'
                                fluid size='large'
                            >
                                Enviar
                            </Button>
                        </div>
                }
            </Segment>
        </Form>
    )
}

export default FormFace
