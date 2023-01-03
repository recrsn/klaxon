import {useEnvironments} from 'Frontend/hooks/environments';
import Loader from 'Frontend/components/Loader';
import {Link} from 'react-router-dom';

export default function EnvironmentsListView() {
  const environments = useEnvironments();
  return (
    <>
      <section className="flex p-m gap-m items-end">
        <h1>Environments</h1>
        <Link to="/environments/new">Create</Link>
        {environments.isLoading && <Loader/>}
        <ul>
          {environments.data?.map((environment) => (
            <li key={environment?.id}>
              <Link
                to={`/environments/${environment.key}`}>{environment.name || environment.key}</Link>
            </li>
          ))}
        </ul>
      </section>
    </>
  );
}
