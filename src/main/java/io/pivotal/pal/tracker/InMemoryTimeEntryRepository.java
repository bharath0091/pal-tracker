package io.pivotal.pal.tracker;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class InMemoryTimeEntryRepository implements TimeEntryRepository{

    private Map<Long, TimeEntry> inMemoryStore = new HashMap<>();
    private long idCount = 1;

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        TimeEntry newTimeEntry = new TimeEntry(idCount, timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours());
        inMemoryStore.put(idCount++, newTimeEntry);
        return newTimeEntry;
    }

    @Override
    public TimeEntry find(long id) {
        return inMemoryStore.get(id);
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<>(inMemoryStore.values());
    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {
        if (inMemoryStore.get(id) != null) {
            TimeEntry updatedEntry = new TimeEntry(id, timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours());
            inMemoryStore.put(id, updatedEntry);
            return inMemoryStore.get(id);
        } else {
            return null;
        }
    }

    @Override
    public void delete(long id) {
        if (inMemoryStore.get(id) != null) {
            inMemoryStore.remove(id);
        }
    }
}
