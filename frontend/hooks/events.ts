import { useQuery } from '@tanstack/react-query';
import { EventEndpoint } from '../generated/endpoints';

export function useEventsByEnvironment(key: string) {
  const { data, error, isLoading } = useQuery({
    queryKey: ['events', 'byEnvironment', key],
    queryFn: () => EventEndpoint.getEventsByEnvironment(key),
  });
  return { data, error, isLoading };
}
