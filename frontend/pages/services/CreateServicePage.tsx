import { useForm } from 'react-hook-form';
import { useCreateEnvironment } from 'Frontend/hooks/environments';
import { TextField } from '@hilla/react-components/TextField.js';
import { Notification } from '@hilla/react-components/Notification.js';
import { useNavigate } from 'react-router-dom';
import ServiceRequest from 'Frontend/generated/com/recrsn/klaxon/dto/ServiceRequest';

export default function CreateServicePage() {
  const { register, handleSubmit } = useForm();
  const createEnvironment = useCreateEnvironment();
  const navigate = useNavigate();

  const createServiceHandler = async (data: ServiceRequest) => {
    await createEnvironment.mutate(data);
    Notification.show(`Service ${data.key} created`);
    navigate('/environments');
  };

  return (
    <>
      <section className="flex p-m gap-m items-end">
        <h1>Create Environment</h1>
      </section>
      <section className="flex p-m gap-m items-end">
        <form onSubmit={handleSubmit(createServiceHandler)}>
          <div>
            <TextField label="Key" required={true} {...register('key', { required: true })} />
          </div>
          <div>
            <TextField label="Name" {...register('name')} />
          </div>
          <div>
            <TextField label="Description" {...register('description')} />
          </div>
          <div>
            <button type="submit" disabled={createEnvironment.isLoading}>
              Create
            </button>
          </div>
        </form>
      </section>
    </>
  );
}
